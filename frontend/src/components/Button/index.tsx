import React from 'react'

type Props = {
  text: string;
  submit?: boolean;
}

const Button = ({text, submit}: Props) => {
  return (
    <div className="col-12">
      <button className="btn btn-primary" type={submit ? "submit" : "button"}>{text}</button>
    </div>
  )
}

export default Button;
