
import React, {Component} from 'react';
import './Card.css';

class BCard extends Component {
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
            <div className="credit-card lithic selectable">
                <div className="credit-card-last4">
                    **** **** **** {this.props.last_four}
                </div>
                <div className="credit-card-expiry">
                    {this.props.validthru}
                </div>

                <img src="https://lever-client-logos.s3.us-west-2.amazonaws.com/0b238bae-848b-443f-841e-6409f20067d6-1621513307422.png" />
            </div>
        );
    }
}

export default BCard;

