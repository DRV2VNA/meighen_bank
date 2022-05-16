
import React, {Component} from 'react';
import './Card.css';

const imgs = [
    {
        name: "Lithic",
        imgurl: "https://lever-client-logos.s3.us-west-2.amazonaws.com/0b238bae-848b-443f-841e-6409f20067d6-1621513307422.png"
    },
    {
        name: "Visa",
        imgurl: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Visa_Inc._logo.svg/2560px-Visa_Inc._logo.svg.png"
    },
    {
        name: "Mastercard",
        imgurl: "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/MasterCard_Logo.svg/640px-MasterCard_Logo.svg.png"
    }
];

class BCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            imgsrc:"",
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    findmy(name){
        for(let i = 0; i < imgs.length; ++i) {
            if (imgs[i].name == name) {return imgs[i].imgurl;}
        }
    }

    componentDidMount() {
        let sr = this.findmy(this.props.name);
        console.log("Card from: ", this.props.name);
        console.log("Finded: ", sr);
        this.setState({imgsrc: sr});
    }

    render() {
        const {code, description} = this.state;
        return (
            <div className="credit-card lithic selectable">
                <div className="credit-card-last4">
                    **** **** **** {this.props.last_four}
                </div>
                <div className="credit-card-expiry">
                    {this.props.validthru}
                </div>

                <img src={this.state.imgsrc} />
            </div>
        );
    }
}

export default BCard;

