import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { BrowserRouter } from 'react-router-dom';
import 'typeface-roboto';

import { MuiThemeProvider, createMuiTheme } from '@material-ui/core/styles';
import blue from '@material-ui/core/colors/blue';

const theme = createMuiTheme({
    palette: {
      primary: { main: blue[500] }, // Purple and green play nicely together.
      secondary: { main: '#11cb5f' }, // This is just green.A700 as hex.
    },
    typography: { useNextVariants: true },
  });

ReactDOM.render(
    <MuiThemeProvider theme={theme}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </MuiThemeProvider>, 
    document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
