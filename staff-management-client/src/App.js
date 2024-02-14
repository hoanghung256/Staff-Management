import logo from "./logo.svg";
import { React, useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [staffList, setStaffList] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/staffs")
      .then((res) => setStaffList(res.data))
      .catch((err) => console.log("Error occurred: ", err));
  }, []);
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
        <div>
          <p>{staffList}</p>
        </div>
      </header>
    </div>
  );
}

export default App;
