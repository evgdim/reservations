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
        <nav className="uk-navbar-container uk-margin" uk-navbar="mode: click">
          <div className="uk-navbar-center">
            <ul className="uk-navbar-nav">
              <li className="uk-active"><Link to="/">Home</Link></li>
              <li><Link to="/tasks">Reservations</Link></li>
              <li><Link to="/new">New</Link></li>
            </ul>

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
