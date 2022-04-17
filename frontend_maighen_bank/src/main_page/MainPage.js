import React, {Component} from 'react';

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
            <div className='page-wrap d-flex flex-row align-items-center pt-5'>
                <div className='container'>
                    <div className='row justify-content-center'>
                        MainPage
                    </div>
                    <div className='row justify-content-center'>

                    </div>
                </div>
            </div>
        );
    }
}

export default MainPage;