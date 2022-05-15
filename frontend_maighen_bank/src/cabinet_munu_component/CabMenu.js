
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
                        <button className="tab-btn tab-btn--active">
                            <i className="ph-lightbulb-bold"></i>
                            <span className="tab-btn-title" onClick = {this.props.overviewHandler}>Обзор</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn">
                            <i className="ph-credit-card-bold"></i>
                            <span className="tab-btn-title" onClick = {this.props.cardsHandler}>Карты</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn">
                            <i className="ph-arrows-left-right-bold"></i>
                            <span className="tab-btn-title" onClick = {this.props.transactionsHandler}>Транзакции</span>
                        </button>
                    </li>
                    <li className="tab">
                        <button className="tab-btn">
                            <i className="ph-bank-bold"></i>
                            <span className="tab-btn-title" onClick = {this.props.accountHandler}>Аккаунт</span>
                        </button>
                    </li>
                </ul>
            </nav>
        );
    }
}

export default CabMenu;