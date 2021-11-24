import { ClienteApolice } from "./ClienteApolice";

export interface Apolice {
  id?: string;
  codigo? : number,
  inicioVigencia: string,
  fimVigencia: string,
  placaVeiculo: string,
  valor: number,
  clienteCpf?: string,
}