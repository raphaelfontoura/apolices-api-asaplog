import { Apolice } from "models/Apolice"
import { ApiError } from "models/ApiError";
import { useEffect, useState } from "react";
import axios from "axios";
import { BASE_URL } from "utils/request";
import { Link, useHistory } from "react-router-dom";
import Alert from "components/Alert";
import { Cliente } from "models/Cliente";

type FormEvent = React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>;

const ApoliceForm = () => {
  const [formData, setFormData] = useState<Apolice>({
    inicioVigencia: '',
    fimVigencia: '',
    placaVeiculo: '',
    valor: 0,
  });
  const [error, setError] = useState<ApiError>();

  let history = useHistory();

  const handleOnChange = ({ target }: FormEvent) => {
    setError(undefined);
    const name = target.name;
    const value = target.value;
    // console.log({ name, value });
    setFormData(data => ({ ...data, [name]: value }))
  }

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const payload = {
      ...formData
    }
    console.log(payload);
    axios.post(BASE_URL + "/apolices", payload).then(response => {
      console.log(response.data);
      history.push("/apolices")
    }).catch((error) => {
      console.error(error.response.data);
      setError(error.response.data);
    })
  }

  return (
    <>
    
      <div className="mt-4 mb-2">
        {error?.status === 404 && <Alert>{error?.message}</Alert>}
      </div>
      <form className="row g-3 needs-validation mt-4" onSubmit={handleSubmit}>
        <div className="col-md-12">
          <label htmlFor="validationCustom01" className="form-label">CPF do Cliente</label>
          <input name="clienteCpf"
            value={formData?.clienteCpf}
            onChange={handleOnChange}
            className="form-control"
            id="uf"
            required />
          <div className="invalid-feedback">
            Digite o CPF de um cliente cadastrado.
          </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="validationCustomUsername" className="form-label">Placa do Veículo</label>
          <div className="input-group has-validation">
            <input name="placaVeiculo"
              value={formData?.placaVeiculo}
              onChange={handleOnChange}
              type="text"
              className="form-control"
              id="placaVeiculo"
              aria-describedby="inputGroupPrepend"
              required />
            <div className="invalid-feedback">
              Informe a placa do veículo.
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="validationCustom03" className="form-label">Valor da Apólice</label>
          <input name="valor"
            value={formData?.valor}
            onChange={handleOnChange}
            type="number"
            className={`form-control ${error?.errors?.[0].fieldName === "valor" ? "is-invalid" : ""}`}
            id="valor"
            required />
          <div className="invalid-feedback">
            Digite um valor válido.
          </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="validationCustom03" className="form-label">Data de início</label>
          <input name="inicioVigencia"
            value={formData?.inicioVigencia}
            onChange={handleOnChange}
            type="date"
            className="form-control"
            id="inicioVigencia"
            required />
          <div className="invalid-feedback">
            Entre com uma data.
          </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="validationCustom03" className="form-label">Data final</label>
          <input name="fimVigencia"
            value={formData?.fimVigencia}
            onChange={handleOnChange}
            type="date"
            className="form-control"
            id="fimVigencia"
            required />
          <div className="invalid-feedback">
            Entre com uma data
          </div>
        </div>

        <div className="col-12">
          <button className="btn btn-primary me-2" type="submit">Salvar</button>
          <Link to="/apolices">
            <button className="btn btn-outline-primary" type="button">Voltar</button>
          </Link>
        </div>
      </form>
    </>
  )
}

export default ApoliceForm
