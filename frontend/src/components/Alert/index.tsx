

const Alert = (props: any) => {
  console.log(props);
  return (
    <div className="alert alert-danger" role="alert">
      {props.children}
    </div>
  )
}

export default Alert
