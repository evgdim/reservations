import * as React from 'react';

export interface NewTaskProps {
}

export default class NewTask extends React.Component<NewTaskProps, any> {
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
