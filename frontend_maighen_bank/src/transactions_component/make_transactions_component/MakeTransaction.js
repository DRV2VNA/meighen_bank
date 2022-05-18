import React, {Component} from 'react';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import './MakeTransactions.css';
import CreditCardInput from 'react-credit-card-input';
import Cards from 'react-credit-cards';
import 'react-credit-cards/es/styles-compiled.css';
import CurrencyInput from "react-currency-input-field";
import {Cookies} from "react-cookie";


class MakeTransaction extends Component {
    constructor(props) {
        super(props);
        this.state = {
            st1:"",
            cardNumber:"",
            expiry:"",
            cvc:"",
            focus: '',
            focus2: '',
            name: '',
            number: '',
            number2: '',
            curval: 1000,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleSpanClick = this.handleSpanClick.bind(this);
        this.handleTransactionPerform = this.handleTransactionPerform.bind(this);
    }

    handleSpanClick(event) {
        if (event.target.value == 1) {
            this.setState({st1:" active"});
        }
    }


    handleInputFocus = (e) => {
        this.setState({ focus: e.target.name });
    }

    handleInputChange = (e) => {
        const { name, value } = e.target;

        this.setState({ [name]: value });
    }

    handleCardCVCChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        //console.log(name, " ", value)
        this.setState({
            cardNumber: "sefe"
        });
    }

    // handleCardCVCChange(event) {
    //     const target = event.target;
    //     const value = target.value;
    //     const name = target.name;
    //
    //     //console.log(name, " ", value)
    //     this.setState({
    //         cardNumber: value
    //     });
    // }

    handleTransactionPerform() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        console.log({
            cardFrom: this.state.number,
            cardTo: this.state.number2,
            ammount: this.state.curval,
            cardFromCVV: this.state.cvc,
            cardFromExpDate: this.state.expiry,
            tType: "00"
        })
        if (
            this.state.number != "" && this.state.number.length == 16 &&
            this.state.number2 != "" && this.state.number2.length == 16 &&
            parseFloat(this.state.curval) > 0 &&
                this.state.cvc != "" && this.state.expiry != "" && this.state.expiry.length == 4
        ) {
            console.log("Perform!")
            fetch('/api/cards/transaction', {
                method: 'POST',
                headers: {
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    cardFrom: this.state.number,
                    cardTo: this.state.number2,
                    ammount: this.state.curval.replace(',', '.'),
                    cardFromCVV: this.state.cvc,
                    cardFromExpDate: this.state.expiry[0]+this.state.expiry[1]+"/"+this.state.expiry[2]+this.state.expiry[3],
                    tType: "00"
                })
            });
        }
    }

    render() {
        const {code, description} = this.state;
        return (

            <div>
                <div className="container">
                    <div className="body d-md-flex flex-column pl-5 pr-5">
                        <div className="ml-5 mt-3">
                            <h3>Совершить перевод между карт:</h3>
                        </div>
<br /><br />
                        <div id="PaymentForm" className="d-flex flex-column">
                            <h3>Карта отправителя:</h3>

                            <div className="d-flex flex-row align-items-center flex-wrap">
                                <Cards
                                    cvc={this.state.cvc}
                                    expiry={this.state.expiry}
                                    focused={this.state.focus}
                                    name={this.state.name}
                                    number={this.state.number}
                                />
                                <form className="d-flex flex-column mysshps">
                                    <h5>Номер карты:</h5><input
                                        type="tel"
                                        name="number"
                                        placeholder="Номер карты"
                                        onChange={this.handleInputChange}
                                        onFocus={this.handleInputFocus}
                                    />
                                    <h5>Имя владельца:</h5><input
                                        type="tel"
                                        name="name"
                                        placeholder="Имя владельца:"
                                        onChange={this.handleInputChange}
                                        onFocus={this.handleInputFocus}
                                    />
                                    <h5>Дата действия:</h5><input
                                        type="tel"
                                        name="expiry"
                                        placeholder="Дата действия"
                                        onChange={this.handleInputChange}
                                        onFocus={this.handleInputFocus}
                                    />
                                    <h5>CVC:</h5><input
                                    type="tel"
                                    name="cvc"
                                    placeholder="Дата действия"
                                    onChange={this.handleInputChange}
                                    onFocus={this.handleInputFocus}
                                    />
                                </form>
                            </div>
<br />
                            <div id="PaymentForm" className="d-flex flex-column">
                                <h3>Карта получателя:</h3>
                                <div className="d-flex flex-row align-items-center align-items-center flex-wrap">
                                    <Cards
                                        cvc={""}
                                        expiry={""}
                                        focused={this.state.focus2}
                                        name={""}
                                        number={this.state.number2}
                                    />
                                    <form className="d-flex flex-column mysshps">
                                        <h5>Номер карты:</h5><input
                                        type="tel"
                                        name="number2"
                                        placeholder="Номер карты"
                                        onChange={this.handleInputChange}
                                        onFocus={this.handleInputFocus}
                                    />
                                    </form>
                                </div>
                            </div>


                        </div>
                        <br />
                        <h3>Сумма перевода:</h3>
                        <CurrencyInput
                            id="input-example"
                            name="input-name"
                            placeholder="Please enter a number"
                            defaultValue={1000}
                            decimalsLimit={2}
                            onValueChange={(value, name) => this.setState({curval:value})}
                            suffix=" Рублей" value={this.state.curval}
                        />

                        <br />
                        <div className="d-flex justify-content-center">
                            <Button
                                type="submit"
                                onClick={this.handleTransactionPerform}
                                fullWidth
                                variant="contained"
                                color="#4d6de3"
                            >
                                Перевести!
                            </Button>
                        </div>
                    {/*    <div className="crccontainer">y*/}
                    {/*        <div className="blank_space">*/}
                    {/*            <span className="fieldRow credit_card">*/}
                    {/*              <input id="cc" className="credit_card_number focus" type="text" placeholder="" />*/}
                    {/*              <label for="cc">Credit card number</label>*/}
                    {/*              /!*<i for="cc" className="fa fa-credit-card"></i>*!/*/}
                    {/*              /!*<div className="zoomBtn">ZOOM</div>*!/*/}
                    {/*              /!*<div className="closeBtn"><i className="fa fa-times"></i></div>*!/*/}
                    {/*            </span>*/}
                    {/*        </div>*/}

                    {/*        <span className="fieldRow col2">*/}
                    {/*            <input id="cvv" type="text" placeholder="XXX" />*/}
                    {/*            <label for="cvv">CVV</label>*/}
                    {/*            /!*<i for="cvv" className="fa fa-lock"></i>*!/*/}
                    {/*        </span>*/}

                    {/*        <span className="fieldRow col2 last">*/}
                    {/*            <input id="date" type="text" placeholder="mm/yy" />*/}
                    {/*            <label for="date">Date</label>*/}
                    {/*            /!*<i for="date" className="fa  fa-calendar"></i>*!/*/}
                    {/*        </span>*/}

                    {/*        <button type="submit">PAY NOW</button>*/}


                    {/*    <div className="overlay"></div>*/}
                    {/*</div>*/}


                        <span className="fas fa-times" onClick={this.props.close}></span>
                    </div>
                </div>
            </div>
        );
    }
}

export default MakeTransaction;