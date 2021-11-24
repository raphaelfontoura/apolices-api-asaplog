import axios from "axios";
import Button from "components/Button";
import Spinner from "components/Spinner";
import { Apolice } from "models/Apolice"
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BASE_URL } from "utils/request";


const Apolices = () => {

  const [apolices, setApolices] = useState<Apolice[]>();
  const [isLoading, setIsLoading] = useState(false);
  const [numeroApolice, setNumeroApolice] = useState<number>();

  useEffect(() => {
    setIsLoading(true);
    axios.get(BASE_URL + "/apolices")
    .then(response => {
      setApolices(response.data);
    }).catch(error => {
      console.error(error);
    })
    setIsLoading(false);
  }, [])

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setNumeroApolice(parseInt(e.target.value));
  }

  return (
    <div>
      <div className="input-group mb-3 mt-3">
        <input type="string"
          value = {numeroApolice} 
          onChange = {handleInputChange}
          className="form-control" 
          placeholder="Localizar Apolice" 
          aria-label="Localizar Apolice" aria-describedby="btn-localizar" />
        <Link to={`apolices/${numeroApolice}`} className="btn btn-outline-primary" type="button" id="btn-localizar">
          Buscar
        </Link>
      </div>
      <div className="mt-4 mb-2">
        <Link to="/apolices/nova">
          <Button text="Cadastrar Nova Apolice" />
        </Link>
      </div>
      <table className="table">
        <thead className="thead-light">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Data de início</th>
            <th scope="col">Data final</th>
            <th scope="col">Placa do veículo</th>
            <th scope="col">Valor</th>
          </tr>
        </thead>
        <tbody>
          {isLoading ? <Spinner /> : (
            apolices?.map(apolice => (
              <tr key={apolice.id}>
                <th scope="row">{apolice.codigo}</th>
                <td>{apolice.inicioVigencia}</td>
                <td>{apolice.fimVigencia}</td>
                <td>{apolice.placaVeiculo}</td>
                <td>R$ {apolice.valor}</td>
              </tr>
            ))
          )}

        </tbody>
      </table>
    </div>
  )
}

export default Apolices
