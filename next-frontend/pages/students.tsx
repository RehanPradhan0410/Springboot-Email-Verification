import * as React from "react";
import { useState, useEffect } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import axios from "axios";

const BasicTable = () => {
  const [students, setStudents] = useState([]);

  const fetchStudents = async () => {
    const response = await axios.get("http://localhost:8080/api/student");
    console.log(response.data);
    setStudents(response.data);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  return (
    <>
      <header className="py-5">
        <h1 className="text-center">Students</h1>
      </header>
      <div className="p-5">
        <TableContainer component={Paper} className="bg-blue-300">
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Id</TableCell>
                <TableCell align="right">Name</TableCell>
                <TableCell align="right">Email</TableCell>
                <TableCell align="right">Verified</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {students.map((row: any) => (
                <TableRow key={row.id}>
                  <TableCell component="th" scope="row">
                    {row.id}
                  </TableCell>
                  <TableCell align="right">{row.name}</TableCell>
                  <TableCell align="right">{row.email}</TableCell>
                  <TableCell align="right">
                    {row.verified ? "true" : "false"}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
      <footer className="flex justify-center">
        <a href="/" className="hover:underline">
          Create Student
        </a>
      </footer>
    </>
  );
};

export default BasicTable;
