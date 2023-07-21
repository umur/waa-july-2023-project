export default function Register(){

    const style = {
        margin: 50,
    
    };

    return (
        <div>
            <h1>Register To System</h1>
            <form>
                <div className="form-group">
                    <label>Faculty Name</label>
                    <input type="text" className="form-control" placeholder="Enter Faculty Name" />
                    <label>Faculty State</label>
                    <input type="text" className="form-control" placeholder="Enter State" />
                    <label>Faculty City </label>
                    <input type="text" className="form-control" placeholder="Enter City " />
                    <label>Faculty Major</label>
                    <input type="text" className="form-control" placeholder="Enter Major" />
                    <label>Faculty CV</label>
                    <input type="text" className="form-control" placeholder="Enter CV" />
                    <label>Posted Date</label>
  
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                    </form>  
        </div>
    )

}