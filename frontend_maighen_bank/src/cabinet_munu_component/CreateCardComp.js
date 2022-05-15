
import React, {Component} from 'react';
import './Card.css';
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import './CreateCardComp.css';

const useStyles = (theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(3),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
});

class CreateCard extends Component {
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
                <div className="container">

                    <div className="body d-md-flex flex-column align-items-center">
                        <br />
                        <div><h3>Выберите систему, в которой будет создаваться карта:</h3></div>

                        <div className="d-md-flex flex-row flex-wrap">
                            <div className="crcard">
                                <img src="https://logowik.com/content/uploads/images/lithic5526.jpg" />
                            </div>
                            <div className="crcard">
                                <img src="https://www.pngplay.com/wp-content/uploads/8/Visa-Logo-PNG-Photos.png" />
                            </div>
                            <div className="crcard">
                                <img src="https://logowik.com/content/uploads/images/lithic5526.jpg" />
                            </div>
                            <div className="crcard">
                                <img src="https://logowik.com/content/uploads/images/lithic5526.jpg" />
                            </div>
                        </div>

                        <span className="fas fa-times" onClick={this.props.close}></span>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateCard;

