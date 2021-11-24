import React from 'react'

type InputAttibutes = {
  className: string;
  label: string;
  required: boolean;
  alert: string;
  type?: string;
  value?: string;
}
const Input = ({className, label, required, alert, type, value}: InputAttibutes) => {
  return (
    <div className={className}>
        <label htmlFor="validationCustom01" className="form-label">{label}</label>
        <input type={type || "text"} className="form-control" id="validationCustom01" required={required} value={value} />
        <div className="invalid-feedback">
          {alert}
        </div>
      </div>
  )
}

export default Input
