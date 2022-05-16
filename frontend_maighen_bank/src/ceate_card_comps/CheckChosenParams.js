
import React, {Component} from 'react';
import '../cabinet_munu_component/Card.css';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import '../cabinet_munu_component/CreateCardComp.css';
import {withStyles} from "@material-ui/core";
import './CheckChosenParams.css';

const systems = [
    {
        name: "Lithic",
        imgurl: "https://logowik.com/content/uploads/images/lithic5526.jpg"
    },
    {
        name: "Visa",
        imgurl: "https://www.pngplay.com/wp-content/uploads/8/Visa-Logo-PNG-Photos.png"
    },
    {
        name: "Mastercard",
        imgurl: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/800px-Mastercard-logo.svg.png"
    }
];

class CheckChosenParams extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            curcardselected: -1,
            crn:"не выбрано",
            description: props.description ? props.description : 'Unknown error'
        }

    }

    componentDidMount() {
        // this.setState({ccs:systems[this.props.cardsystem].name});

        if(this.props.currency == 10) {}
        switch (this.props.currency) {
            case 10:
                this.setState({crn:"RUR (Рубли РФ)"});
                break;
            case 20:
                this.setState({crn:"USD (Доллары США)"});
                break;
            case 30:
                this.setState({crn:"EUR (Евро)"});
                break;
        }
    }

    render() {
        const {code, description} = this.state;
        const { classes } = this.props;

        return (
            <div>
                <div><h3>Подтверждение выбора:</h3></div><br /><br />

                <div className="d-md-flex flex-column flex-wrap">

                    <div><h5>Система карты: </h5> <i>{this.props.cardsystem>0?systems[this.props.cardsystem-1].name:""}</i></div>
                    <div><h5>Фамилия: </h5> <i>{this.props.usersurname}</i></div>
                    <div><h5>Имя: </h5> <i>{this.props.username}</i></div>
                    <div><h5>Описание карты: </h5> <i>{this.props.carddesc}</i></div>
                    <div><h5>Валюта карты: </h5> <i>{this.state.crn}</i></div>

                    <div className="d-flex align-items-center justify-content-center">
                        <span><h4>Создавая карту, вы так же соглашаетесь с нашими условиями обслуживания.   </h4></span><input type="checkbox" id="bien" />
                        <label className="good" htmlFor="bien"></label>
                    </div>
                    {/*<input type="checkbox" id="mal" />*/}
                    {/*<label className="wrong" htmlFor="mal"></label>*/}

                </div>
            </div>
        );
    }
}

export default CheckChosenParams;
