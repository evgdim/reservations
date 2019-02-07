import * as React from 'react';

export interface ReservationsProps {
}

export interface ReservationsState {
  reservations: any
}

export default class Reservations extends React.Component<ReservationsProps, ReservationsState> {
  constructor(props: ReservationsProps) {
    super(props);
    this.state = {
      reservations: {}
    }
  }
  
  
  componentDidMount() {
    fetch("http://localhost:8080/reservations?name=asd", { method:'GET', headers: new Headers({'Authorization':'Basic ' + btoa("user:password")})})
    .then(res => res.json())
    .then(data => {
      console.log("in then")
      console.log(data)
      this.setState(prevState => {
        reservations: data
      })
    })
    .catch(err => console.error(err))
  }
  public render() {
    console.log(this.state)
    return (
      <div>
        Reservations: {this.state.reservations.id}
      </div>
    );
  }
}
