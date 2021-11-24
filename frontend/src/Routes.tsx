import Navbar from "components/Navbar";
import Apolices from "pages/Apolices";
import ApoliceDetails from "pages/Apolices/ApoliceDetails";
import ApoliceForm from "pages/Apolices/ApoliceForm";
import Clientes from "pages/Clientes";
import ClienteForm from "pages/Clientes/ClienteForm";
import Home from "pages/Home";
import { BrowserRouter, Switch, Route } from "react-router-dom";

const Routes = () => (
  <BrowserRouter>
    <Navbar />
    <div className="container">
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route exact path="/clientes">
          <Clientes />
        </Route>
        <Route path="/clientes/novo">
          <ClienteForm />
        </Route>
        <Route path="/apolices" exact>
          <Apolices />
        </Route>
        <Route path="/apolices/nova">
          <ApoliceForm />
        </Route>
        <Route path="/apolices/:codigoId" children={<ApoliceDetails />} />
      </Switch>
    </div>
  </BrowserRouter>
);

export default Routes;

