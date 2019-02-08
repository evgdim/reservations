// import * as React from 'react';

// export interface ReservationsProps {
// }

// export interface ReservationsState {
//   reservations: any
// }

// export default class Reservations extends React.Component<ReservationsProps, ReservationsState> {
//   constructor(props: ReservationsProps) {
//     super(props);
//     this.state = {
//       reservations: []
//     }
//   }
  
  
//   componentDidMount() {
//     fetch("http://localhost:8080/reservations?name=asd", { method:'GET', headers: new Headers({'Authorization':'Basic ' + btoa("user:password")})})
//     .then(res => res.json())
//     .then(data => {
//       this.setState({
//         reservations: data
//       })
//     })
//     .catch(err => console.error(err))
//   }

//   public render() {
//     let reservationsList = this.state.reservations.map((r: any) => 
//       <tr key={r.id}>
//         <th scope="row"></th>
//         <td>{r.description}</td>
//         <td>-</td>
//         <td>-</td>
//       </tr>);
//     return (
//       <div>
//         <table className="table">
//         <thead>
//           <tr>
//             <th scope="col">#</th>
//             <th scope="col">Description</th>
//             <th scope="col">Start</th>
//             <th scope="col">End</th>
//           </tr>
//         </thead>
//         <tbody>
//           {reservationsList}
//         </tbody>
//         </table>
//       </div>

//     );
//   }
// }

import * as React from 'react';

export interface ReservationsProps {
}

export default function Reservations (props: ReservationsProps) {
    const [count, setCount] = React.useState(1);
    return (
      <div>
        Clicks: {count}
        <button onClick={() => setCount(count + 1)}>Click Me</button>
      </div>
    );
}
