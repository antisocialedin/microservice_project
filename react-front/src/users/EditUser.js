import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditUser() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [user, setUser] = useState({
    nome: "",
    idade: "",
    telefone: "",
  });

  const { nome, idade, telefone} = user;


  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8000/user/${id}`, user);
    navigate("/");
  };

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8000/user/${id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Editar Usuário</h2>

                <form onSubmit={(e) => onSubmit(e)}>
                    
                    <div className="mb-3">
                        <label htmlFor="Nome" className="form-label">
                            Nome
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Digite seu nome"
                            name="nome"
                            value={nome}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="Idade" className="form-label">
                            Idade
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Ex: 21"
                            name="idade"
                            value={idade}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="Telefone" className="form-label">
                            Telefone
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Ex:(11)91234-5678"
                            name="telefone"
                            value={telefone}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>

                    <button type="submit" className="btn btn-outline-primary">
                        Confirmar
                    </button>
                    
                    <Link className="btn btn-outline-danger mx-2" to="/">
                        Cancelar
                    </Link>
                                    
                </form>
            </div>
        </div>
    </div>
  )
}
