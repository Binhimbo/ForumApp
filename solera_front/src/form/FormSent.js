import { useState } from "react";

const FormSent = (props) => {
  return (
    <div>
      <h2>Thread: {props.thread}</h2>
      <h2>Title: {props.title}</h2>
      <br />
      <h2>Category: {props.category}</h2>

      <br />
      <p>{props.text}</p>
    </div>
  );
};

export default FormSent;
