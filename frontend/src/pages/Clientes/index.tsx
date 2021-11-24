import axios from "axios";
import Button from "components/Button";
import Spinner from "components/Spinner";
import { Cliente } from "models/Cliente";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BASE_URL } from "utils/request";


const Clientes = () => {

  const [clientes, setClientes] = useState<Cliente[]>();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    axios.get(BASE_URL + "/clientes").then(response => {
      setClientes(response.data);
    }).catch(error => {
      console.error(error);
    })
    setIsLoading(false);
  }, [])

  return (
    <div>
      <div className="mt-4 mb-2">
        <Link to="/clientes/novo">
          <Button text="Cadastrar Novo Cliente" />
        </Link>
      </div>
      <table className="table">
        <thead className="thead-light">
          <tr>
            <th scope="col">Nome Completo</th>
            <th scope="col">CPF</th>
            <th scope="col">Cidade</th>
            <th scope="col">UF</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          {isLoading ? <Spinner /> : (
            clientes?.map(cliente => (
              <tr key={cliente.id}>
                <td>{cliente.nomeCompleto}</td>
                <td>{cliente.cpf}</td>
                <td>{cliente.cidade}</td>
                <td>{cliente.uf}</td>
              </tr>
            ))
          )}
          
        </tbody>
      </table>
    
    </div>
  )
}

export default Clientes

