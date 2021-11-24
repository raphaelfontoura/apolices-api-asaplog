import axios from "axios";
import { ApoliceCompleta } from "models/ApoliceCompleta"
import { useEffect, useState } from "react"
import { useParams } from "react-router";
import { BASE_URL } from "utils/request";

type Props = {
  codigoId: string,
}

const ApoliceDetails = () => {

  const [apolice, setApolice] = useState<ApoliceCompleta>({
    codigo: "",
    placaVeiculo: '',
    inicioVigencia: '',
    fimVigencia: '',
    valor: 0,
    venceu: false,
    diasCorridos: 0
  });

  let { codigoId } = useParams<Props>();

  useEffect(() => {
    axios.get(BASE_URL + "/apolices/" + codigoId).then(res => {
      setApolice(res.data);
    }).catch(err => {
      console.log(err.response.data);
    })
  }, [])

  return (
    <div className="card">
      <div className="card-header">
        Apolice número #{apolice.codigo}
      </div>
      <ul className="list-group list-group-flush">
        <li className="list-group-item">Placa do Veículo: {apolice.placaVeiculo}</li>
        <li className="list-group-item">Valor: R$ {apolice.valor}</li>
        <li className="list-group-item">Data de Início: {apolice.inicioVigencia}</li>
        <li className="list-group-item">Data de Fim: {apolice.fimVigencia}</li>
        <li className="list-group-item">Vencido: {apolice.venceu ? "sim" : "não"}</li>
        {!apolice.venceu &&
          <li className="list-group-item">Dias para vencer: {apolice.diasCorridos}</li>
        }
        {apolice.venceu &&
          <li className="list-group-item">Dias vencidos: {apolice.diasCorridos}</li>
        }
      </ul>
    </div>
  )
}

export default ApoliceDetails
