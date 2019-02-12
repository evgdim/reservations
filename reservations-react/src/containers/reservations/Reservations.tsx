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
