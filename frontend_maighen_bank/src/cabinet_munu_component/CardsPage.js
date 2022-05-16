import React, {Component} from 'react';
import Card from "./Card";
import BCard from "./Card";
import {Cookies} from "react-cookie";
import './CardsPage.css';
import CardInfoPanel from "./CardInfoPanel";

class CardsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cards:[],
            addcardtab:false,
            hiddencards:[],
            showingallcards: false,
            doptoadditcards: "hid",
            showPopup:true,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleShowAllCards = this.handleShowAllCards.bind(this);
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
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return response;
            }

            return response.json();
        });
    }

    async componentDidMount() {
        let cards = await this.getCards();
        console.log(cards);

        let trcards = cards.cards;
        let arrc = [];
        let brrc = [];
        //console.log(trcards.length);
        if (trcards == null) {return;}
        let cnt = trcards.length<=5?trcards.length:5;
        for(let i = 0; i < trcards.length ; ++i) {
            let vt = ("0" + trcards[i].expMonth).slice(-2) + '/' + trcards[i].expYear.toString().substr(-2);
            console.log("vt=",vt);

            if (i <= cnt) {
                arrc.push(
                    <div className="bcard">
                        <BCard last_four={trcards[i].lastFour} validthru={vt} name={trcards[i].cardIssuerName}/>
                    </div>
                );
            } else {
                brrc.push(
                    <div className="bcard">
                        <BCard last_four={trcards[i].lastFour} validthru={vt} name={trcards[i].cardIssuerName}/>
                    </div>
                );
            }
        }
        this.setState({
            cards:arrc,
            hiddencards:brrc
        });
    }

    handleShowAllCards() {
        if (this.state.showingallcards) {
            this.setState({doptoadditcards: "hid"});
        } else {
            this.setState({doptoadditcards: ""});
        }
        this.setState({showingallcards: !this.state.showingallcards})
    }

    render() {
        const {code, description} = this.state;
        return (
            <section className="overview">

                {/*<div className={"main-popup " + (this.state.showPopup ? "" : "hid")}>*/}
                {/*    <CardInfoPanel*/}
                {/*        text='Close Me'*/}
                {/*        // closePopup={this.togglePopup.bind(this)}*/}
                {/*    />*/}
                {/*</div>*/}


                <header className="overview-header">
                    <h2 className="overview-header-title">Ваши карты: </h2>

                    <div className="button-add-card" role="button" onClick={this.props.togger}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                             className="bi bi-plus-square" viewBox="0 0 16 16">
                            <path
                                d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                            <path
                                d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                        </svg>
                        {/*<img className="add-card" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFD81KfvpG4YoWVPHJwpwGvqBBWeohozCZhw&usqp=CAU" />*/}
                    </div>

                    {/*<Slide direction="down" in={logintab} mountOnEnter unmountOnExit>*/}
                    {/*</Slide>*/}
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

                            {/*<CardInfoPanel last_four="4558" validthru="05/12" name="visa"/>*/}

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

                        <div className={"list-item mcssitem " + this.state.doptoadditcards}>
                            {/*<div className="bcard">*/}
                            {/*    <BCard />*/}
                            {/*</div>*/}

                            {this.state.hiddencards}

                        </div>
                    </div>
                </div>
                <footer className="overview-footer">
                    <h6 onClick={this.handleShowAllCards}>Показать все карты</h6>
                    {/*<a href="#" >*/}
                    {/*    <img className="add-card" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFD81KfvpG4YoWVPHJwpwGvqBBWeohozCZhw&usqp=CAU" />*/}
                    {/*</a>*/}
                </footer>
            </section>
        );
    }
}

export default CardsPage;

