import React, {Component} from 'react';
import './TranactionsComp.css';
import transferimg from './img.png';
import Transaction from "./Transaction";
import DailyTransactions from "./DailyTransactions";
import {Cookies} from "react-cookie";
import Login from "../login_component/Login";
import {Slide} from "@material-ui/core";
import MakeTransaction from "./make_transactions_component/MakeTransaction";

class TranactionsComp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            transactionholder: false,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.close = this.close.bind(this);
        this.handleOpenTransaction = this.handleOpenTransaction.bind(this);
    }


    async getTransacrions() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        return await fetch('/api/cards/transaction', {
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            }),
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return '-';
            }

            return response.json();
        });
    }

    async componentDidMount() {
        let mtranactions = await this.getTransacrions();

        await this.setState({tranactions : mtranactions.transactions});

        // console.log(mtranactions);
        let datesArray = [];
        let uniqueObjArray = [
            ...new Map(mtranactions.transactions.map((item) => [item["performed"], item])).values(),
        ];
        for(let i = 0; i < uniqueObjArray.length; ++i) {
            // console.log(mtranactions.transactions[0].performed);
            datesArray.push(uniqueObjArray[i].performed);
        }
        console.log(uniqueObjArray);
        datesArray.sort(function(a,b){
            // Turn your strings into dates, and then subtract them
            // to get a value that is either negative, positive, or zero.
            return new Date(b) - new Date(a);
        });

        console.log(datesArray);

        let trdatescomps = [];
        for(let j = 0; j < datesArray.length; ++j) {
            trdatescomps.push(
                <DailyTransactions transactions={mtranactions.transactions} date={datesArray[j]}/>
            );
        }

        await this.setState({dtp: trdatescomps});
    }

    close() {
        this.setState({transactionholder:false});
    }

    handleOpenTransaction() {
        this.setState({transactionholder:true});
    }

    render() {
        const {code, description} = this.state;
        return (
            <section className="overview">
                <div className="list">
                    <h2>Совершить операцию</h2>
                    <div className="d-flex flex-row my_oper">
                        <div className="d-flex flex-row" onClick={this.handleOpenTransaction}>
                            <div className="list-item my_oper_chose mr-5 align-items-center justify-content-center">
                                <img src={transferimg} />
                                Перевести на карту
                            </div>
                        </div>
                        <div className="d-flex flex-row">
                            <div className="list-item my_oper_chose mr-5 align-items-center justify-content-center">
                                <img src="https://cdn.icon-icons.com/icons2/2645/PNG/512/arrow_down_up_icon_160466.png" />
                                Пополнить карту
                            </div>
                        </div>
                    </div>
                </div> <br />

                <header className="overview-header">
                    <h2 className="overview-header-title">Ваши транзакции:<span></span></h2>
                    {/*<a href="src/transactions_component/TransactionsComp#" className="link">View all</a>*/}
                </header>
                <div className="overview-body">
                    {this.state.dtp}
                </div>
                <footer className="overview-footer">
                    {/*<a href="src/transactions_component/TransactionsComp#" className="link">View all transactions<i*/}
                    {/*    className="ph-arrow-right-bold"></i></a>*/}
                </footer>

                <Slide direction="down" in={this.state.transactionholder} mountOnEnter unmountOnExit>
                    <div className="pabs d-flex justify-content-center align-items-center">
                        <MakeTransaction close={this.close} />
                    </div>
                </Slide>
            </section>
        );
    }
}

export default TranactionsComp;

