import React, { useState } from "react";
import ListTransactions from "../list/ListTransactions";
import styles from "./FormUpload.module.css";
import InputFile from "./inputs/InputFile";

export default function FormUpload() {
  const [file, setFile] = useState();
  const [data, setData] = useState({});
  function handleFileChange({ target }) {
    console.log(target.files[0]);
    setFile(target.files[0]);
  }
  async function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData();
    formData.append("file", file);
    let response;
    let json;
    response = await fetch("http://localhost:8080/api/v1/parser", {
      method: "POST",
      body: formData,
    });
    json = await response.json();
    setData(json);
    console.log(Object.keys(data));
  }
  return (
    <div className={`container ${styles.formUpload}`}>
      <form onSubmit={handleSubmit}>
        <p>Select file to upload</p>
        <InputFile file={file} onChange={handleFileChange} />
        <button onClick={handleSubmit}>Upload</button>
      </form>
      {Object.keys(data).map((key, index) => (
        <ListTransactions
          key={`transaction-${index}`}
          store={key}
          data={data[key]}
        />
      ))}
    </div>
  );
}
