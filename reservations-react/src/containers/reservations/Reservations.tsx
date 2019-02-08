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
      reservations: []
    }
  }
  
  
  componentDidMount() {
    fetch("http://localhost:8080/reservations?name=asd", { method:'GET', headers: new Headers({'Authorization':'Basic ' + btoa("user:password")})})
    .then(res => res.json())
    .then(data => {
      this.setState({
        reservations: data
      })
    })
    .catch(err => console.error(err))
  }

  public render() {
    let reservationsList = this.state.reservations.map((r: any) => <div key={r.id}>{r.description}</div>);
    return (
      <div>
        Reservations: {reservationsList}
      </div>
    );
  }
}
