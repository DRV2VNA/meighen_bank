
import React, {Component} from 'react';
import Header from "../header/Header";
import CabMenu from '../cabinet_munu_component/CabMenu';
import './CardPageCss.css';
import TransactionsComp from "../transactions_component/TransactionsComp";
import BCard from "../cabinet_munu_component/Card";
import CardsPage from "../cabinet_munu_component/CardsPage";
import AuthElement from "../auth_element/AuthElement";
import Login from "../login_component/Login";
import {Slide} from "@material-ui/core";
import CreateCard from "../cabinet_munu_component/CreateCardComp";
import {Cookies} from "react-cookie";
import './HoverMenuButtons.css';

class CardPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username : "username",
            createcardtab: false,
            currentDayState: "Добрый день",
            isTranactions: false,
            userBalance: '-',
            overviewhidden: "",
            fnm: "Пользователь",
            lnm: "",
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.overviewHandler = this.overviewHandler.bind(this);
        this.transactionsHandler = this.transactionsHandler.bind(this);
        this.cardsHandler = this.cardsHandler.bind(this);
        this.accountHandler = this.accountHandler.bind(this);
        this.showAddCards = this.showAddCards.bind(this);
        this.exitHandle = this.exitHandle.bind(this);
    }

    overviewHandler() {
        this.setState({
            currentPage: "overview",
            overviewhidden: ""
        })
    }

    transactionsHandler() {
        this.setState({
            currentPage: "tranactions",
            overviewhidden: "hid"
        })
    }

    cardsHandler() {
        this.setState({
            currentPage: "cards",
            overviewhidden: "hid"
        })
    }

    accountHandler() {
        this.setState({
            currentPage: "account",
            overviewhidden: "hid"
        })
    }

    showAddCards() {
        // console.log(22)
        this.setState({
            createcardtab:!this.state.createcardtab
        })
    }

    async getBalance() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        return await fetch('/api/user/private/balance', {
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

    exitHandle() {
        const cookies = new Cookies();
        cookies.remove('accessToken');
        cookies.remove('refreshToken');
        cookies.remove('username');

        cookies.remove('fname');
        cookies.remove('lname');

        window.location = '/';
    }

    async componentDidMount() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        let fn = cookies.get('fname');
        let ln = cookies.get('lname');

        let balance = await this.getBalance();
        console.log("balance", balance)
        this.setState({userBalance: balance.balance, username: b, fnm : fn, lnm:ln});
    }

    render() {
        const {code, description} = this.state;
        return (
            <div className="meighen-app">
                <AuthElement />

                <svg xmlns="http://www.w3.org/2000/svg" className="nnn">
                    <symbol id="meighen" viewBox="0 0 118 94">
                        <title>Meighen</title>
                        <path fill-rule="evenodd" fill="#4d6de3" clip-rule="evenodd" d="M 19.4 61.4 l 36.379 0 l -18.1894 -41.0132 l -18.1896 41.0132 z m 42.5954 -42.4 l 18.8046 42.4 l -37.6092 0 l 18.8046 -42.4 z"></path>
                    </symbol>
                </svg>

                <header className="header">
                    <svg className="bi me-2" width="100" height="100" role="img" aria-label="Bootstrap">
                        <use xlinkHref="#meighen"></use>
                    </svg>
                    <a href="/"><h1 className="header-logo">meighen</h1></a>
                    <div className="header-content">
                        {/*<div className="header-search">*/}
                        {/*    <input type="text" className="search-field" placeholder="Search..."/>*/}
                        {/*    <button type="submit" className="search-btn">*/}
                        {/*        <i className="ph-magnifying-glass-bold"></i>*/}
                        {/*    </button>*/}
                        {/*</div>*/}
                        <button className="header-avatar">
                            {/*<span className="header-avatar-img"></span>*/}
                            <img  className="header-avatar-img" src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Breezeicons-actions-22-im-user.svg/1200px-Breezeicons-actions-22-im-user.svg.png" />
                            <span className="header-avatar-name">{this.state.fnm + " " + this.state.lnm}</span>
                            <div className="avatar-menu">
                                <button onClick={this.exitHandle}>Выход</button>
                            </div>
                        </button>
                    </div>
                </header>
                <main className="main">
                    <CabMenu overviewHandler={this.overviewHandler}
                             transactionsHandler={this.transactionsHandler} cardsHandler={this.cardsHandler} accountHandler={this.accountHandler}
                    />

                    <div className="content">
                        <div className={"content-header " + this.state.overviewhidden}>
                            <div className="content-header-inner">
                                <h1 className="content-header-title">{this.state.currentDayState}, <i>{this.state.fnm + " " + this.state.lnm}</i>. <br/><br/>
                                     Ваш баланс: <small> ₽ {this.state.userBalance}</small>
                                </h1>
                            </div>
                            <div className="content-header-illustration">
                                <img src="https://cdn.banki.ru/static/bundles/ui-2018/InfoBundle/about-page/images/suitcases.b816708a2c.png"/>
                            </div>
                        </div>
                        <div className="content-body">
                            {/*<TransactionsComp />*/}
                            {(this.state.currentPage=="tranactions") ? <TransactionsComp /> : ""}
                            {(this.state.currentPage=="cards") ? <CardsPage togger={this.showAddCards}/> : ""}

                            {/*<CardPage />*/}
                            {/*<div className="bcard">*/}
                            {/*    <BCard />*/}
                            {/*</div>*/}

                            {/*<CardsPage />*/}

                        </div>
                    </div>
                </main>

                <div className="pabs d-flex justify-content-center align-items-center">
                    <Slide direction="down" in={this.state.createcardtab} mountOnEnter unmountOnExit>
                        <CreateCard closer={this.showAddCards}/>
                    </Slide>
                </div>
            </div>
        );
    }
}

export default CardPage;