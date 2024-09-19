import './App.css';
import React, { useState, useEffect } from 'react';

const App = () => {
  const [results, setResults] = useState('');

  useEffect(() => {
    // call API
    fetch('http://localhost:8080/EmployeeList')
      .then((response) => response.json())
      .then((data) => setResults(JSON.stringify(data)));
  }, []);

  const handleClick = () => {
    // call API
    fetch('http://localhost:8080/EmployeeList')
      .then((response) => response.json())
      .then((data) => setResults(JSON.stringify(data)));
  }

  return (
    <div>
      <button onClick={handleClick}>Call API</button>
      <p>{results}</p>
    </div>
  );
}
export default App;
