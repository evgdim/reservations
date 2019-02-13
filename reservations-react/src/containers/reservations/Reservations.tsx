import * as React from 'react';

export interface ReservationsProps {
}

export default function Reservations (props: ReservationsProps) {
    const [data, setData] = React.useState({ reservations: [] });
    React.useEffect(() => {
      fetch("http://localhost:8080/reservations?name=asd", { method:'GET', headers: new Headers({'Authorization':'Basic ' + btoa("user:password")})})
      .then(res => res.json())
      .then(resp => {
        console.log(resp);
        setData({reservations: resp});
      })
      .catch(err => console.error(err))
    }, []);
    return (
      <div>
        <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Description</th>
            <th scope="col">Start</th>
            <th scope="col">End</th>
          </tr>
        </thead>
        <tbody>
          {data.reservations.map((r: any) => 
                    <tr key={r.id}>
                      <th scope="row"></th>
                      <td>{r.description}</td>
                      <td>{r.start}</td>
                      <td>{r.end}</td>
                    </tr>  
          )}
        </tbody>
        </table>
      </div>
    );
}
