
import React, {Component} from 'react';
import Transaction from "./Transaction";

class DailyTransactions extends Component {
    constructor(props) {
        super(props);
        this.state = {
            options : { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' },
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    async componentDidMount() {
        let obj = this.props.transactions;

        console.log('fff ',this.props.date)
        let date = new Date(this.props.date);
        console.log(date)
        let datexformat = date.toLocaleString('ru', {
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });

        // var dateFormat = require('dateformat');
        // var now = new Date();
        // dateFormat(date, "dddd, mmmm dS, yyyy, h:MM:ss TT");

        await this.setState({datexformat: datexformat})

        let trt = [];
        console.log('obj', this.props.transactions);
        for(let i = 0; i < obj.length; ++i) {
            console.log(obj[i]);
            console.log(obj[i].performed == this.props.date);
            if (obj[i].performed == this.props.date) {
                trt.push(
                    <Transaction from={obj[i].sendFrom} to={obj[i].sendTo} ammount={obj[i].ammount}
                                 time={obj[i].performed} completed={obj[i].completed}/>
                );
            }
        }

        await this.setState({trt:trt});
    }

    render() {
        const {code, description} = this.state;
        return (
            <div>
                <div className="summary">
                    <h3 className="summary-date">{this.state.datexformat}</h3>
                    <span className="summary-amount"></span>
                </div>
                <div className="list">
                    {this.state.trt}
                </div>
            </div>
        );
    }
}

export default DailyTransactions;