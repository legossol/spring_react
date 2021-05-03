import JoinUserForm from "./JoinUserForm"
const JoinUser = (props) =>{
    console.log("JoinUser props: ",JSON.stringify(props))

    return(
        <>
        <h2>JOIN</h2>
        <JoinUserForm></JoinUserForm>
        </>
    )
}

export default JoinUser