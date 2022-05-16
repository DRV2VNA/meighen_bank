
import React, {Component} from 'react';
import '../cabinet_munu_component/Card.css';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import '../cabinet_munu_component/CreateCardComp.css';
import {withStyles} from "@material-ui/core";
import './ChoseSystemComp.css'

const systems = [
    {
        name: "Lithic",
        imgurl: "https://logowik.com/content/uploads/images/lithic5526.jpg"
    },
    {
        name: "Visa",
        imgurl: "https://www.pngplay.com/wp-content/uploads/8/Visa-Logo-PNG-Photos.png"
    },
    {
        name: "Mastercard",
        imgurl: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/800px-Mastercard-logo.svg.png"
    }
        ];


class ChoseSystem extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            curcardselected: -1,
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleChoseSystem = this.handleChoseSystem.bind(this)
    }

    handleChoseSystem(event) {
        const target = event.target;
        const value = target.attributes.getNamedItem("value").value;
        const name = "target.name";

        this.setState({curcardselected:value});
        this.props.changedata(value);

        // console.log(value)

        // console.log(name, " ", value)
        // this.setState({
        //     [name]: value
        // });
    }

    renderSystems() {
        let a = [];
        for (let i = 0; i < systems.length; ++i) {
            a.push(
                <div className="crcard" value={i+1} onClick={this.handleChoseSystem}>
                    <div className={this.state.curcardselected==i+1?"divonprelative":"dispnone"} value={i+1}>
                        <span className="electric" value={i+1}>Выбрано</span>
                    </div>
                    <img src={systems[i].imgurl} value={i+1}/>
                </div>
            );
        }

        return a;
    }

    render() {
        const {code, description} = this.state;
        const { classes } = this.props;

        return (
            <div>
                <div><h3>Выберите систему, в которой будет создаваться карта:</h3></div><br /><br />

                <div className="d-md-flex flex-row flex-wrap">
                    {/*<div className="">*/}
                    {/*    <div className="">*/}
                    {/*        <div className="">*/}
                    {/*            <img src="https://logowik.com/content/uploads/images/lithic5526.jpg" />*/}
                    {/*        </div>*/}
                    {/*        <div className="">*/}
                    {/*            <h2>Lithic</h2>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {this.renderSystems()}

                    {/*<div className="crcard" value={1} onClick={this.handleChoseSystem}>*/}
                    {/*    <div className={this.state.curcardselected==1?"divonprelative":"dispnone"}>*/}
                    {/*        <span className="electric">Выбрано</span>*/}
                    {/*    </div>*/}
                    {/*    <img src="https://logowik.com/content/uploads/images/lithic5526.jpg"  value={1}/>*/}
                    {/*</div>*/}
                    {/*<div className="crcard" value={2} onClick={this.handleChoseSystem}>*/}
                    {/*    <div className={this.state.curcardselected==2?"divonprelative":"dispnone"}>*/}
                    {/*        <span className="electric">Выбрано</span>*/}
                    {/*    </div>*/}
                    {/*    <img src="https://www.pngplay.com/wp-content/uploads/8/Visa-Logo-PNG-Photos.png" value={2} />*/}
                    {/*</div>*/}
                    {/*<div className="crcard" value={3} onClick={this.handleChoseSystem}>*/}
                    {/*    <div className={this.state.curcardselected==3?"divonprelative":"dispnone"}>*/}
                    {/*        <span className="electric">Выбрано</span>*/}
                    {/*    </div>*/}
                    {/*    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/800px-Mastercard-logo.svg.png" value={3} />*/}
                    {/*</div>*/}
                    {/*<div className="crcard">*/}
                    {/*    <img src="https://logowik.com/content/uploads/images/lithic5526.jpg" />*/}
                    {/*</div>*/}
                </div>
            </div>
        );
    }
}

export default ChoseSystem;
