
import React, {Component} from 'react';
import logo_success from './img_1.png';
import logo_failture from './img_2.png';
import {Cookies} from "react-cookie";

class Transaction extends Component {
    constructor(props) {
        super(props);
        this.state = {
            transactions:[],
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }


    render() {
        const {code, description} = this.state;
        return (
            <div className="list-item">
                <div className="list-item-company">
                    <figure className="list-item-company-logo">
                        <img src={ this.props.completed?logo_success:logo_failture}/>
                    </figure>
                    <div className="list-item-company-info">
                        <h4 className="list-item-company-name">С карты {this.props.from}</h4>
                        <a href="src/transactions_component/TransactionsComp#" className="list-item-company-hashtag">На карту {this.props.to}</a>
                    </div>
                </div>
                <div className="list-item-transaction">
                    <div className="list-item-transaction-values">
                    <span className="list-item-transaction-value">
                      <i className="ph-arrows-clockwise-bold"></i>{this.props.ammount}
                    </span>
                        <time className="list-item-transaction-time"
                              dateTime="17:00">{this.props.time}
                        </time>
                    </div>
                    <button className="list-item-transaction-action">
                        <i className="ph-caret-down-bold"></i>
                    </button>
                </div>
            </div>
        );
    }
}

export default Transaction;