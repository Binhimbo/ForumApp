import { useState } from "react";
import listPost from "./listPost";
import NewForm from "./NewForm";

function UserForm() {
  var thread = ["Politics", "Sports", "Videogames", "Cooking"];

  const [show, setShow] = useState(false);
  const [newform, setNewform] = useState(false);
  const [chosenthread, setChosenthread] = useState("");
  const [titulo, setTitulo] = useState("");
  const selectThread = (e) => {
    const thisthread = e.target.value;
    setChosenthread(thisthread);
  };
  //selecciona el thread

  const showTitle = () => {
    setShow(show ? false : true);
    console.log(chosenthread);
  };

  const checkTitle = () => {
    setTitulo(document.getElementById("title").value);
    console.log({ titulo });
    var confirmar = false;
    const found = listPost.find((list) => list.titulo === titulo);
    console.log(found);
    if (found) confirmar = true;

    if (confirmar) {
      alert("titulo ya existe");
    } else {
      alert("puedes crear el post");
    }
    setNewform(newform ? false : true);
  };

  return (
    <div>
      <label>Select a thread</label>
      <br />
      <select onChange={selectThread}>
        {thread.map((element) => {
          return <option key={element}>{element}</option>;
        })}
      </select>
      <br />
      <button type="button" onClick={showTitle}>
        Pick thread
      </button>
      <br />
      {show && (
        <div>
          <label>Introduce a title</label>
          <br />
          <input type="text" id="title" placeholder="title" />
          <button type="button" id="button-title" onClick={checkTitle}>
            check title
          </button>
        </div>
      )}
      {newform && (
        <div>
          <NewForm thread={chosenthread} title={titulo} />
        </div>
      )}
    </div>
  );
}

export default UserForm;
