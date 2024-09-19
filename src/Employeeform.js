import React, { useState } from 'react';
import axios from 'axios';
import EmployeeTable from './EmployeeTable';

const Employeeform = () => {
  const [employeeName, setEmployeeName] = useState('');
  const [employeeEmail, setEmployeeEmail] = useState('');
  const [employeeAddress, setEmployeeAddress] = useState('');
  const [employees, setEmployees] = useState([]);
  const [result, setResult] = useState('');

  const handleAddemployee = () => {
    axios.post('http://localhost:8080/registerEmployee', {
        employeeName: employeeName,
        employeeEmail: employeeEmail,
        employeeAddress: employeeAddress
    }).then(response => {
      console.log(response);
      // Set the result state to the response data
      setResult(response.data);
    }).catch(error => {
      console.log(error);
    });
  };

  const handleDisplayemployees = () => {
    axios.get('http://localhost:8080/EmployeeList').then(response => {
      setEmployees(response.data);
    }).catch(error => {
      console.log(error);
    });
};

return (
  <div>
    <label>Employee Name:</label>
    <input type="text" name="employeeName" value={employeeName} onChange={e => setEmployeeName(e.target.value)} />

    <label>Employee Email:</label>
    <input type="text" name="employeeEmail" value={employeeEmail} onChange={e => setEmployeeEmail(e.target.value)} />

    <label>Employee Address:</label>
    <input type="text" name="employeeAddress" value={employeeAddress} onChange={e => setEmployeeAddress(e.target.value)} />

    <button onClick={handleAddemployee}>Add Employee</button>
    <button onClick={handleDisplayemployees}>Display Employees</button>

    <EmployeeTable employees={employees} />

        {/* Display the result */}
    {result && (
    <p>The Employee with name {result.employeeName}, Email; {result.employeeEmail} and Physical Address {result.employeeAddress} was successfully registered.</p>
    )}

  </div>
);
};

export default Employeeform;
