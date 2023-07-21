export default function ResetPassword(){

    const style = {
        margin: 75,
       
    };
    return (
        <div>
            <h1>Reset Possword</h1>
           
            {/* <fieldset style={style}> */}
            <form>
                <div className="form-group">
                   
                    <label>UserName</label>
                    <input type="text" className="form-control" placeholder="Enter User Name" />
                    <label>Old Password</label>
                    <input type="text" className="form-control" placeholder="Enter Old Password" />
                    <label>New Password</label>
                    <input type="text" className="form-control" placeholder="Enter New Password" />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
    
                    </form>
                    
                    {/* </fieldset> */}
        </div>
    )
}