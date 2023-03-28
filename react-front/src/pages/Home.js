import React, { useEffect, useState } from 'react'
import axios from "axios"
import { Link, useParams } from "react-router-dom";

export default function Home() {
  
  const [user, setUser] = useState([])
  
  const { id } = useParams();

  useEffect( () => {
    loadUsers()
  },[])

  const loadUsers = async () =>{
    const result = await axios.get("http://localhost:8080/users")
    setUser(result.data)
  }

  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8080/user/${id}`);
    loadUsers();
  };

  return (
    <div className='container'>
        <div className='py-4'>
            <table className="table border shadow">
            <thead>
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Nome</th>
                <th scope="col">Idade</th>
                <th scope="col">Telefone</th>
                <th scope="col"></th>
                </tr>
            </thead>
            <tbody> {/*dinamic data on front */}
                {
                  user.map((user,index) => ( 
                    <tr>
                    <th scope="row" key={index}>{index+1}</th>
                    <td>{user.nome}</td>
                    <td>{user.idade}</td>
                    <td>{user.telefone}</td>
                    <td>
                      <Link className="btn btn-primary mx-2" to={`/viewuser/${user.id}`}>Ver</Link>
                      <Link className="btn btn-outline-primary mx-2" to={`/edituser/${user.id}`}>Editar</Link>
                      <button className="btn btn-danger mx-2" onClick={() => deleteUser(user.id)}>Remover</button>
                    </td>
                    </tr>
                  ))
                }
            </tbody>
            </table>
        </div>
    </div>
  )
}
