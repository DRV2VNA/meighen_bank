
import React, {Component} from 'react';
import './Card.css';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import './CreateCardComp.css';
import {withStyles} from "@material-ui/core";
import ChoseSystem from "../ceate_card_comps/ChoseSystemComp";
import FillBasicParametersToChoseCard from "../ceate_card_comps/FillBasicParametersToChoseCard";
import CheckChosenParams from "../ceate_card_comps/CheckChosenParams";
import {Cookies} from "react-cookie";




class CreateCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentPage: 1,
            prevcolortab: "der",
            systemSelected:-1,
            username:"",
            usersurname:"",
            currency:"",
            carddesc:"",
            cur_desc:"Далее",
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.doNextChosePage = this.doNextChosePage.bind(this);
        this.doPrevChosePage = this.doPrevChosePage.bind(this);
    }

    createNewCard() { //credentials as param
        //console.log(JSON.stringify(credentials));
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        let cardSystem = this.state.systemSelected;
        let currency = this.state.currency;
        let cardDesc = this.state.carddesc;

        fetch('/api/cards/create', {
            method: 'POST',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            }),
            body: JSON.stringify({cardSystem, currency, cardDesc})
        });

        this.props.closer();
    }

    async doNextChosePage() {
        if (this.state.currentPage < 3) {
            await this.setState({currentPage: this.state.currentPage + 1});
        }

        if (this.state.currentPage === 3 && this.state.cur_desc === "Создать!") {
            this.createNewCard();
        }
        console.log("Changed to:", this.state.currentPage)

        if (this.state.currentPage==1) {
            this.setState({prevcolortab: "der", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        } else if (this.state.currentPage==3) {
            this.setState({prevcolortab: "", nextcolortab: "deri"})
            this.setState({cur_desc: "Создать!"});
        } else if (this.state.currentPage==2) {
            this.setState({prevcolortab: "", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        } else {
            this.setState({prevcolortab: "", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        }
    }

    doPrevChosePage() {
        console.log(this.state.currentPage)
        if (this.state.currentPage > 1) {
            this.setState({currentPage: this.state.currentPage - 1});
        }

        if (this.state.currentPage==1) {
            this.setState({prevcolortab: "der", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        } else if (this.state.currentPage==3) {
            this.setState({prevcolortab: "", nextcolortab: "deri"});
            this.setState({cur_desc: "Создать!"});
        } else if (this.state.currentPage==2) {
            this.setState({prevcolortab: "", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        } else {
            this.setState({prevcolortab: "", nextcolortab: ""})
            this.setState({cur_desc: "Далее"});
        }
    }

    render() {
        const {code, description} = this.state;

        return (
            <div>
                <div className="container">

                    <div className="body d-md-flex flex-column align-items-center card-checker-comp">
                        <br />
                        {this.state.currentPage===1?<ChoseSystem changedata={(Name) => this.setState({systemSelected: Name})}/>:""}
                        {this.state.currentPage===2?<FillBasicParametersToChoseCard changedata={(uname, usname, desc, curr) => this.setState({
                            usersurname:usname, username:uname, currency:curr, carddesc:desc })} />:""}
                        {this.state.currentPage===3?<CheckChosenParams
                            cardsystem={this.state.systemSelected} usersurname={this.state.usersurname}
                            username={this.state.username} currency={this.state.currency}
                        />:""}


                        <div className="mcontainer round" >
                            <div className="ctn" onClick={this.doPrevChosePage}>

                                <h1 className="target">
                                    <div className={"content " + this.state.prevcolortab}>
                                        <div className="rounded"></div>
                                        <svg height="32px" className="arrow"
                                             version="1.1" viewBox="0 0 32 32" width="32px" xmlSpace="preserve"
                                             xmlns="http://www.w3.org/2000/svg"
                                             xlinkHref="http://www.w3.org/1999/xlink"><path fill="#161616" d="M28,14H8.8l4.62-4.62C13.814,8.986,14,8.516,14,8c0-0.984-0.813-2-2-2c-0.531,0-0.994,0.193-1.38,0.58l-7.958,7.958  C2.334,14.866,2,15.271,2,16s0.279,1.08,0.646,1.447l7.974,7.973C11.006,25.807,11.469,26,12,26c1.188,0,2-1.016,2-2  c0-0.516-0.186-0.986-0.58-1.38L8.8,18H28c1.104,0,2-0.896,2-2S29.104,14,28,14z"/></svg>
                                        <span className="title">Назад</span>
                                    </div>
                                </h1>
                            </div>
                            <div className="ctn" onClick={this.doNextChosePage}>
                                <div>
                                    <h1 className="target">
                                        <div className={"content reversed " + this.state.nextcolortab}   >
                                            <div className="rounded"></div>
                                            <svg height="32px" className="arrow reverse"
                                                 version="1.1" viewBox="0 0 32 32"
                                                 width="32px" xmlSpace="preserve" xmlns="http://www.w3.org/2000/svg"
                                                 xlinkHref="http://www.w3.org/1999/xlink"><path fill="#161616" d="M28,14H8.8l4.62-4.62C13.814,8.986,14,8.516,14,8c0-0.984-0.813-2-2-2c-0.531,0-0.994,0.193-1.38,0.58l-7.958,7.958  C2.334,14.866,2,15.271,2,16s0.279,1.08,0.646,1.447l7.974,7.973C11.006,25.807,11.469,26,12,26c1.188,0,2-1.016,2-2  c0-0.516-0.186-0.986-0.58-1.38L8.8,18H28c1.104,0,2-0.896,2-2S29.104,14,28,14z"/></svg>
                                            <span className="title">{this.state.cur_desc}</span>
                                        </div>
                                    </h1>
                                </div>
                            </div>
                        </div>


                        <span className="fas fa-times" onClick={this.props.closer}></span>
                    </div>
                </div>
            </div>
        );
    }
}

export default (CreateCard);
