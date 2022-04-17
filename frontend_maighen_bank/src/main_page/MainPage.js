import React, {Component} from 'react';
import Header from "../header/Header";
import './card_css.css';
import MPCard from "./CardComp";
import './main_page.css';

class MainPage extends Component {
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
            <div>
                <Header />
                <div className='page-wrap d-flex flex-row align-items-center pt-5'>
                    <div className='container'>
                        {/*<div className='row justify-content-center'>*/}
                        {/*    MainPage*/}
                        {/*</div>*/}
                        <div className='row justify-content-center align-items-center mto'>
                            <div className='col'>
                                <p className="m_txt"><span className="mb_txt">Meighen Bank </span> - площадка создания виртуальных банковских продуктов.</p>
                            </div>
                            <div className='col'>
                                <div className="card1">
                                    <MPCard logo_id={1}/>
                                </div>
                                <div className="card2">
                                    <MPCard logo_id={2}/>
                                </div>
                            </div>
                        </div>
                        <div> </div>
                        <div className='row justify-content-center'>
                            <p className="m_txt">Здесь вы млжете беспрепятственно создавать, предлагаемые вам банковские продукты.</p>
                            <p className="m_txt">Например, вы можете создать карты для оплаты различных подписок - так никто не сможет списать лишние суммы с вас!</p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}


export default MainPage;