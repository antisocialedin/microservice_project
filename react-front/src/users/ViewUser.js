import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {

    const { id } = useParams();

    const [user, setUser] = useState({
        nome: "",
        idade: "",
        telefone: "",
    })

    const { nome, idade, telefone} = user;
    
  useEffect(() => {
    loadUser()
  }, [])

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8000/user/${id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Detalhes do Usuário</h2>
                    
                <div className="card">
                    <div className="card-header">
                     Detalhes do usuário id : {user.id}
                        <ul className="list-group list-group-flush">
                        
                            <li className="list-group-item">
                                <b>Nome:</b>
                                {user.nome}
                            </li>

                            <li className="list-group-item">
                                <b>Idade:</b>
                                {user.idade}
                            </li>

                            <li className="list-group-item">
                                <b>Telefone:</b>
                                {user.telefone}
                            </li>

                        </ul>
                    </div>
                </div>

                <Link className="btn btn-primary my-2" to={"/"}>
                    Voltar
                </Link>

            </div>
        </div>
    </div>
  );
}