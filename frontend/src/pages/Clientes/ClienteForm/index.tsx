import axios from "axios";
// import Alert from "components/Alert";
import { Cliente } from "models/Cliente"
import { ApiError } from "models/ApiError";
import { useState } from "react"
import { Link, useHistory } from "react-router-dom";
import { BASE_URL } from "utils/request";

type FormEvent = React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>;

const ClienteForm = () => {

  const [formData, setFormData] = useState<Cliente>({
    nomeCompleto: '',
    cidade: '',
    cpf: '',
    uf: 'Escolha...'
  });
  const [error, setError] = useState<ApiError>()

  let history = useHistory();

  const handleOnChange = ({ target }: FormEvent) => {
    setError(undefined);
    const name = target.name;
    const value = target.value;
    setFormData(data => ({ ...data, [name]: value }))
  }

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const payload = {
      ...formData
    }
    // console.log(payload);
    axios.post(BASE_URL + "/clientes", payload).then(response => {
      // console.log(response.data);
      history.push("/clientes");
    }).catch((error) => {
      console.error(error.response.data);
      setError(error.response.data);
    })
  }

  return (
    <>
      {/* <div className="m-4">
      {error && <Alert>{error.errors[0].message}</Alert>}
    </div> */}
      <form className="row g-3 needs-validation mt-4" onSubmit={handleSubmit}>
        <div className="col-md-12">
          <label htmlFor="validationCustom01" className="form-label">Nome Completo</label>
          <input name="nomeCompleto"
            value={formData?.nomeCompleto}
            onChange={handleOnChange}
            type="text"
            className="form-control"
            id="nomeCompleto"
            required />
          <div className="invalid-feedback">
            Digite o nome completo
          </div>
        </div>
        <div className="col-md-4">
          <label htmlFor="validationCustomUsername" className="form-label">CPF</label>
          <div className="input-group has-validation">
            <input name="cpf"
              value={formData?.cpf}
              onChange={handleOnChange}
              type="text"
              className={`form-control ${error?.errors?.[0].fieldName === "cpf" ? "is-invalid" : ""}`}
              id="cpf"
              aria-describedby="inputGroupPrepend"
              required />
            <div className="invalid-feedback">
              {error?.errors?.[0].fieldName === "cpf" ?
                error.errors[0].message : "Digite o CPF."}
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="validationCustom03" className="form-label">Cidade</label>
          <input name="cidade"
            value={formData?.cidade}
            onChange={handleOnChange}
            type="text"
            className="form-control"
            id="cidade"
            required />
          <div className="invalid-feedback">
            Informe o nome da cidade.
          </div>
        </div>
        <div className="col-md-3">
          <label htmlFor="validationCustom04" className="form-label">Estado</label>
          <select name="uf"
            value={formData?.uf}
            onChange={handleOnChange}
            className="form-select"
            id="uf"
            required>
            <option disabled defaultValue="escolha">Escolha...</option>
            <option value="AC">Acre</option>
            <option value="AL">Alagoas</option>
            <option value="AP">Amapá</option>
            <option value="AM">Amazonas</option>
            <option value="BA">Bahia</option>
            <option value="CE">Ceará</option>
            <option value="DF">Distrito Federal</option>
            <option value="ES">Espírito Santo</option>
            <option value="GO">Goiás</option>
            <option value="MA">Maranhão</option>
            <option value="MT">Mato Grosso</option>
            <option value="MS">Mato Grosso do Sul</option>
            <option value="MG">Minas Gerais</option>
            <option value="PA">Pará</option>
            <option value="PB">Paraíba</option>
            <option value="PR">Paraná</option>
            <option value="PE">Pernambuco</option>
            <option value="PI">Piauí</option>
            <option value="RJ">Rio de Janeiro</option>
            <option value="RN">Rio Grande do Norte</option>
            <option value="RS">Rio Grande do Sul</option>
            <option value="RO">Rondônia</option>
            <option value="RR">Roraima</option>
            <option value="SC">Santa Catarina</option>
            <option value="SP">São Paulo</option>
            <option value="SE">Sergipe</option>
            <option value="TO">Tocantins</option>
          </select>
          <div className="invalid-feedback">
            Informe o Estado.
          </div>
        </div>

        <div className="col-12">
          <button className="btn btn-primary me-2" type="submit">Salvar</button>
          <Link to="/clientes">
            <button className="btn btn-outline-primary" type="button">Voltar</button>
          </Link>
        </div>
      </form>
    </>
  )
}

export default ClienteForm
