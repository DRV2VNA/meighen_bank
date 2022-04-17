import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Routes, Route, Switch, BrowserRouter} from "react-router-dom";
// import Layout from '../containers/Layout'
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
    render()
    {
        return (

            // <BrowserRouter>
            //     <Switch>
            //         {/*<Route exact path={'/'} component={MainPage}/>*/}
            //
            //     </Switch>
            // </BrowserRouter>
            <h1>Hello, world!</h1>
        );
    }
}

export default App;
