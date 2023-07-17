export default function Counter(props){
    return (
        <div>
            Current Value: {props.curValue}
            <input 
                type='button' 
                value='+' 
                onClick={props.onIncClicked}
                />
        </div>
    )
}