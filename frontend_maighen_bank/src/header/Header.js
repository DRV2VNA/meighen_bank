import React, {Component} from 'react';
import './header.css'

class Header extends Component {
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

            <header>
                <svg xmlns="http://www.w3.org/2000/svg" className="nnn">
                    <symbol id="meighen" viewBox="0 0 118 94">
                        <title>Meighen</title>
                        <path fill-rule="evenodd" fill="#4d6de3" clip-rule="evenodd" d="M 19.4 61.4 l 36.379 0 l -18.1894 -41.0132 l -18.1896 41.0132 z m 42.5954 -42.4 l 18.8046 42.4 l -37.6092 0 l 18.8046 -42.4 z"></path>
                    </symbol>
                    <g id="about">
                        <path className="about_s1" d="M 0.9375 3.75 C 0.9375 2.355469 2.355469 0.9375 3.75 0.9375 L 26.25 0.9375 C 27.644531 0.9375 29.0625 2.355469 29.0625 3.75 L 29.0625 23.25 C 29.0625 24.644531 27.644531 26.0625 26.25 26.0625 L 5.183594 26.0625 L 0.9375 29.601562 Z M 0.9375 3.75 "/>
                        <path className="about_s2" d="M 26.25 1.125 C 27.550781 1.125 28.875 2.449219 28.875 3.75 L 28.875 23.25 C 28.875 24.550781 27.550781 25.875 26.25 25.875 L 5.113281 25.875 L 5.011719 25.960938 L 1.125 29.199219 L 1.125 3.75 C 1.125 2.449219 2.449219 1.125 3.75 1.125 L 26.25 1.125 M 26.25 0.75 L 3.75 0.75 C 2.25 0.75 0.75 2.25 0.75 3.75 L 0.75 30 L 5.25 26.25 L 26.25 26.25 C 27.75 26.25 29.25 24.75 29.25 23.25 L 29.25 3.75 C 29.25 2.25 27.75 0.75 26.25 0.75 Z M 26.25 0.75 "/>
                        <path className="about_s3" d="M 15 6.375 C 14.378906 6.375 13.875 6.878906 13.875 7.5 C 13.875 8.121094 14.378906 8.625 15 8.625 C 15.621094 8.625 16.125 8.121094 16.125 7.5 C 16.125 6.878906 15.621094 6.375 15 6.375 Z M 15 6.375 "/>
                        <path className="about_s4" d="M 16.125 19.5 L 16.125 10.125 L 13.125 10.125 L 13.125 10.875 L 13.875 10.875 L 13.875 19.5 L 13.125 19.5 L 13.125 20.25 L 16.875 20.25 L 16.875 19.5 Z M 16.125 19.5 "/>
                    </g>
                </svg>

                <div className="px-3 py-2 bg-dark ">
                    <div className="container">
                        <div className="d-flex flex-wrap align-items-center justify-content-between">
                            <a href="/"
                               className="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
                                <svg className="bi me-2" width="100" height="100" role="img" aria-label="Bootstrap">
                                    <use xlinkHref="#meighen"></use>
                                </svg>
                            </a>

                            <ul className="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">

                                <li>
                                    <a href="/about" className="nav-link ">
                                        <svg className="bi d-block mx-auto mb-1" width="40" height="40">
                                            <use xlinkHref="#about"></use>
                                        </svg>
                                        О нас
                                    </a>
                                </li>

                                <button className="button-27" role="button">Войти</button>
                                <button className="button-27" role="button">Зарегистрироваться</button>
                            </ul>


                        </div>
                    </div>
                </div>


            </header>
        );
    }
}

export default Header;