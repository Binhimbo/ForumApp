import { useState } from "react";
import FormSent from "./FormSent";

const NewForm = (posts) => {
  const bannedWords = ["caca", "culo", "pedo", "pis"];
  var category = ["question", "suggestion", "clarification"];
  const [chosencategory, setChosencategory] = useState("");
  const [activado, setActivado] = useState(true);
  const [show, setShow] = useState(false);
  const [mitexto, setMitexto] = useState("");

  const checkText = () => {
    const valortexto = document.getElementById("texto").value;
    {
      bannedWords.map((element) => {
        var found = false;
        if (valortexto.indexOf(element) != -1) {
          found = true;
          console.log("hay palabras tabú");
        } else {
          found = false;
        }
        return (
          !found &&
          setActivado((document.getElementById("boton").disabled = false))
        );
      });
    }
  };

  const selectCategory = (e) => {
    const thiscategory = e.target.value;
    setChosencategory(thiscategory);
  };

  const sendForm = () => {
    console.log("Thread ");
    setMitexto(document.getElementById("texto").value);
    setShow(show ? false : true);
  };

  return (
    <div>
      <p>Thread: {posts.thread}</p>
      <br />
      <label>select category</label>
      <select onChange={selectCategory}>
        {category.map((e) => {
          return (
            <option key={e}>
              {posts.thread} {e}
            </option>
          );
        })}
      </select>
      <br />
      <textarea id="texto" rows="5" cols="50" />

      <br />
      <button type="button" onClick={() => checkText()}>
        check text
      </button>
      <button type="button" id="boton" disabled={activado} onClick={sendForm}>
        send Form
      </button>
      <br />
      {show && (
        <FormSent
          thread={posts.thread}
          title={posts.title}
          category={chosencategory}
          text={mitexto}
        />
      )}
    </div>
  );
};

export default NewForm;
