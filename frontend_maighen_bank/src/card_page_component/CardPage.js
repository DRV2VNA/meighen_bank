
import React, {Component} from 'react';
import Header from "../header/Header";
import CabMenu from '../cabinet_munu_component/CabMenu';
import './CardPageCss.css';
import TransactionsComp from "../cabinet_munu_component/TransactionsComp";
import BCard from "../cabinet_munu_component/Card";
import CardsPage from "../cabinet_munu_component/CardsComponent";
import AuthElement from "../auth_element/AuthElement";
import Login from "../login_component/Login";
import {Slide} from "@material-ui/core";
import CreateCard from "../cabinet_munu_component/CreateCardComp";


class CardPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username : "username",
            currentDayState: "Добрый день",
            isTranactions: false,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.overviewHandler = this.overviewHandler.bind(this);
        this.transactionsHandler = this.transactionsHandler.bind(this);
        this.cardsHandler = this.cardsHandler.bind(this);
        this.accountHandler = this.accountHandler.bind(this);
    }

    overviewHandler() {
        this.setState({
            currentPage: "overview"
        })
    }

    transactionsHandler() {
        this.setState({
            currentPage: "tranactions"
        })
    }

    cardsHandler() {
        this.setState({
            currentPage: "cards"
        })
    }

    accountHandler() {
        this.setState({
            currentPage: "account"
        })
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
                            <span className="header-avatar-name">{this.state.username}</span>
                        </button>
                    </div>
                </header>
                <main className="main">
                    <CabMenu overviewHandler={this.overviewHandler}
                             transactionsHandler={this.transactionsHandler} cardsHandler={this.cardsHandler} accountHandler={this.accountHandler}
                    />

                    <div className="content">
                        <div className="content-header">
                            <div className="content-header-inner">
                                <h1 className="content-header-title">{this.state.currentDayState}, {this.state.username}. <br/>
                                     Ваш баланс: <small>$24,920.565464</small>
                                </h1>
                            </div>
                            <div className="content-header-illustration">
                                <img src="https://cdn.banki.ru/static/bundles/ui-2018/InfoBundle/about-page/images/suitcases.b816708a2c.png"/>
                            </div>
                        </div>
                        <div className="content-body">
                            {/*<TransactionsComp />*/}
                            {(this.state.currentPage=="tranactions") ? <TransactionsComp /> : ""}
                            {(this.state.currentPage=="cards") ? <CardsPage /> : ""}

                            {/*<CardPage />*/}
                            {/*<div className="bcard">*/}
                            {/*    <BCard />*/}
                            {/*</div>*/}

                            {/*<CardsPage />*/}

                        </div>
                    </div>
                </main>

                <Slide direction="down" in={1} mountOnEnter unmountOnExit>
                    <div className="pabs d-flex justify-content-center align-items-center">
                        <CreateCard />
                    </div>
                </Slide>
            </div>
        );
    }
}

export default CardPage;