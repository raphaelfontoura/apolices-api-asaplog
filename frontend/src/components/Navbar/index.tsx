import React from 'react'
import { NavLink } from 'react-router-dom'

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container-fluid">
        <NavLink to="/" className="navbar-brand">ApoliceAsap</NavLink>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
          aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <li className="nav-item">
              <NavLink to="/apolices" className="nav-link">Apolices</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/clientes" className="nav-link">Clientes</NavLink>
            </li>
          </div>
        </div>
      </div>
    </nav>
  )
}

export default Navbar
