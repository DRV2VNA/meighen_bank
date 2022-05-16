
import React, {Component} from 'react';
import '../cabinet_munu_component/Card.css';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import '../cabinet_munu_component/CreateCardComp.css';
import {MenuItem, Select, withStyles} from "@material-ui/core";
import './ChoseSystemComp.css'
import {Cookies} from "react-cookie";


class FillBasicParametersToChoseCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            curcardselected: -1,
            uname:"",
            usurname:"",
            cardDesc:"",
            currency:10,
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleInputChangeCardDesc = this.handleInputChangeCardDesc.bind(this);
    }

    async getUserInfo() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch('/api/user/private/info', {
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
        let userInf = await this.getUserInfo();

        this.setState({
            uname:userInf.firstName,
            usurname:userInf.secondName
        });
    }

    handleInputChangeCardDesc(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        //console.log(name, " ", value)
        this.setState({
            cardDesc: value
        });

        this.props.changedata(this.state.uname, this.state.usurname, this.state.cardDesc, this.state.currency);
    }

    render() {
        const {code, description} = this.state;
        const { classes } = this.props;

        return (
            <div className="w-50">
                <div><h3>Введите необходимые данные:</h3></div><br /><br />

                    <div className="d-md-flex flex-row align-items-center">
                        <div className="mr-2"><h5><b>Фамилия:</b></h5></div>
                        <TextField
                            variant="filled"
                            required
                            fullWidth
                            name="usurname"
                            label="Может быть изменено в кабинете"
                            type="usurname"
                            id="usurname"
                            autoComplete="Ваша фамилия"
                            disabled={true}
                            value={this.state.usurname}
                            className="inputgrname"
                            // onChange={this.handleInputChange}
                        />
                    </div>
                <br />

                    <div className="d-md-flex flex-row align-items-center">
                        <div className="mr-2"><h5><b>Имя:</b></h5></div>
                        <TextField
                            variant="filled"
                            required
                            fullWidth
                            name="uname"
                            label="Может быть изменено в кабинете"
                            type="uname"
                            id="uname"
                            autoComplete="Ваше имя"
                            disabled={true}
                            value={this.state.uname}
                            // onChange={this.handleInputChange}
                        />
                    </div>
                <br />

                    <div className="d-md-flex flex-row align-items-center">
                        <div className="mr-2"><h5><b>Кратое название карты:</b></h5></div>
                        <TextField
                            variant="outlined"
                            required
                            fullWidth
                            name="cardDesc"
                            label="Например: Пятерочка или Spotify"
                            type="cardDesc"
                            id="cardDesc"
                            autoComplete="Название карты"
                            onChange={this.handleInputChangeCardDesc}
                        />
                    </div>
                <br />

                <div className="d-md-flex flex-row align-items-center">
                    <div className="mr-2"><h5><b>Валюта карты:</b></h5></div>
                    <Select
                        labelId="demo-simple-select-filled-label"
                        id="demo-simple-select-filled"
                        value={10}
                        disabled={true}
                        // onChange={handleChange}
                    >
                        <MenuItem value={10}>Рубли</MenuItem>
                        <MenuItem value={20}>Доллары</MenuItem>
                        <MenuItem value={30}>Евро</MenuItem>
                    </Select>
                </div>

            </div>
        );
    }
}

export default FillBasicParametersToChoseCard;
