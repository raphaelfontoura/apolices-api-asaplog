import { Apolice } from "./Apolice";

export type ApoliceCompleta = Apolice & {
  venceu: boolean,
  diasCorridos: number
}