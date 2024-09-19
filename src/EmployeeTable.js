import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const EmployeeTable = ({ employees }) => {
  return (
    <table className="table table-striped">
      <thead className="thead-dark">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Address</th>
        </tr>
      </thead>
      <tbody>
        {employees.map(employee => (
          <tr key={employee.id}>
            <td>{employee.id}</td>
            <td>{employee.employeeName}</td>
            <td>{employee.employeeEmail}</td>
            <td>{employee.employeeAddress}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default EmployeeTable;
