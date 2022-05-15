import React, {Component} from 'react';
import Card from "./Card";
import BCard from "./Card";
import {Cookies} from "react-cookie";

class CardsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cards:[],
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    async getCards() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        return await fetch('/api/cards/all', {
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            }),
        }).then(response => {
            return response.json();
        });
    }

    async componentDidMount() {
        let cards = await this.getCards();
        console.log(cards);

        let trcards = cards.cards;
        let arrc = [];
        console.log(trcards.length);
        for(let i = 0; i < trcards.length; ++i) {
            let vt = ("0" + trcards[i].expMonth).slice(-2) + '/' + trcards[i].expYear.toString().substr(-2);
            console.log("vt=",vt);
            arrc.push(
                <div className="bcard">
                    <BCard last_four={trcards[i].lastFour} validthru={vt} />
                </div>
            );
        }
        this.setState({
            cards:arrc
        });
    }

    render() {
        const {code, description} = this.state;
        return (
            <section className="overview">
                <header className="overview-header">
                    <h2 className="overview-header-title">Ваши карты: </h2>

                    <button className="button-add-card" role="button" onClick={this.showLogin}>
                        <img className="add-card" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFD81KfvpG4YoWVPHJwpwGvqBBWeohozCZhw&usqp=CAU" />
                    </button>
                    {/*<a href="#" >*/}
                    {/*    <img className="add-card" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFD81KfvpG4YoWVPHJwpwGvqBBWeohozCZhw&usqp=CAU" />*/}
                    {/*</a>*/}
                </header>
                <div className="overview-body">
                    <div className="list">
                        <div className="list-item mcssitem">
                            {/*<div className="bcard">*/}
                            {/*    <BCard />*/}
                            {/*</div>*/}

                            {this.state.cards}

                            </div>
                            {/*<div className="list-item-transaction">*/}
                            {/*    <div className="list-item-transaction-values">*/}
                            {/*        <span className="list-item-transaction-value">*/}
                            {/*          <i className="ph-arrows-clockwise-bold"></i>-$9.99*/}
                            {/*        </span>*/}
                            {/*        <time className="list-item-transaction-time"*/}
                            {/*              dateTime="17:00">5:00pm*/}
                            {/*        </time>*/}
                            {/*    </div>*/}
                            {/*    <button className="list-item-transaction-action">*/}
                            {/*        <i className="ph-caret-down-bold"></i>*/}
                            {/*    </button>*/}
                            {/*</div>*/}
                        {/*</div>*/}
                    </div>
                </div>
                <footer className="overview-footer">
                    {/*<a href="#" >*/}
                    {/*    <img className="add-card" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFD81KfvpG4YoWVPHJwpwGvqBBWeohozCZhw&usqp=CAU" />*/}
                    {/*</a>*/}
                </footer>
            </section>
        );
    }
}

export default CardsPage;

