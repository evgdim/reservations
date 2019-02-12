import * as React from 'react';
import Button from '@material-ui/core/Button';

export interface HomeProps {
}

export default function Home (props: HomeProps) {
    return (
      <div>
        Home
        <Button variant="contained" color="primary">
          Primary
        </Button>
      </div>
    );
}
