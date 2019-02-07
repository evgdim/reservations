import * as React from 'react';

export interface NewReservationProps {
}

export default class NewReservation extends React.Component<NewReservationProps, any> {
  handleCreateClick = () => {
    console.log('click');
  }
  public render() {
    return (
      <div>
        <button onClick={this.handleCreateClick}>Create</button>
      </div>
    );
  }
}
