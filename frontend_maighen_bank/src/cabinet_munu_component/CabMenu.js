
import React, {Component} from 'react';
import Header from "../header/Header";
import CardPage from "../card_page_component/CardPage";
import './CabMenuCss.css';

class CabMenu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    render() {
        const {code, description} = this.state;
        return (
            <nav className="nav">
                <ul className="tabs">
                    <li className="tab">
                        <button className="tab-btn tab-btn--active" onClick = {this.props.overviewHandler}>
                            <i className="ph-lightbulb-bold"></i>
                            <span className="tab-btn-title" >Обзор</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn" onClick = {this.props.cardsHandler}>
                            <i className="ph-credit-card-bold"></i>
                            <span className="tab-btn-title" >Карты</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn" onClick = {this.props.transactionsHandler}>
                            <i className="ph-arrows-left-right-bold"></i>
                            <span className="tab-btn-title" >Транзакции</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn" onClick = {this.props.accountHandler}>
                            <i className="ph-bank-bold"></i>
                            <span className="tab-btn-title" >Аккаунт</span>
                        </button>
                    </li>
                </ul>
            </nav>
        );
    }
}

export default CabMenu;