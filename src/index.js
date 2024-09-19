import React from 'react';
import ReactDOM from 'react-dom';
import Employeeform from './Employeeform';
import 'bootstrap/dist/css/bootstrap.min.css';
const App = () => {
  return (
    <div className="container">
      <div className="jumbotron mt-5">
  
        <h1 className="display-4">Employee Registration Project- Olasunkanmi Sodunke</h1>
        <p className="lead">This is a simple employee registration form built with React and Bootstrap.</p>
        <p className="lead">JAVA TDP Class Project</p>
        <hr className="my-4" />
        <Employeeform />
      </div>
    </div>
  );
};

ReactDOM.render(
  <App />,
  document.getElementById('root')
);

