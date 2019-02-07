import React, { Component } from 'react';
import { Route, Switch } from 'react-router';
import { Link } from 'react-router-dom';

import './App.css';

import Home from './containers/home/Home';
import Reservations from './containers/reservations/Reservations';
import NewReservation from './containers/new-reservation/NewReservation';

class App extends Component {
  render() {
    return (
      <div>
        
              {/* <Link to="/">Home</Link>
              <Link to="/tasks">Reservations</Link>
              <Link to="/new">New</Link> */}
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="#">Navbar</a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
              {/* <a className="nav-item nav-link active" href="#">Home <span className="sr-only">(current)</span></a>
              <a className="nav-item nav-link" href="#">Features</a>
              <a className="nav-item nav-link" href="#">Pricing</a>
              <a className="nav-item nav-link disabled" href="#">Disabled</a> */}
              <Link to="/" className="nav-item nav-link active">Home</Link>
              <Link to="/tasks" className="nav-item nav-link">Reservations</Link>
              <Link to="/new" className="nav-item nav-link">New</Link>
            </div>
          </div>
        </nav>

        <div className="uk-container">
          <Switch>
            <Route path="/" exact component={Home}></Route>
            <Route path="/tasks" component={Reservations}></Route>
            <Route path="/new" component={NewReservation}></Route>
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
