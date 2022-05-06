import React from "react";

const InputFile = ({ file, onChange }) => {
  return (
    <label htmlFor="file">
      File:
      <input id="file" name="file" type="file" onChange={onChange}></input>
    </label>
  );
};

export default InputFile;
