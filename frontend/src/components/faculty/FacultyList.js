const FacultyList = ({ faculties, title, handleUpdate, handleDelete}) => {

    return ( 
        <>
            <div>
                <h2>{title}</h2>
                <div className="mt-5">
                    <table className="table">
                    <thead>
                        <tr>
                        <th scope="col">ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Title</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                        faculties.map(faculty => (
                            <tr key={faculty.id}>
                            <td>{faculty.id}</td>
                            <td>{faculty.firstName}</td>
                            <td>{faculty.lastName}</td>
                            <td>{faculty.email}</td>
                            <td>{faculty.phone}</td>
                            <td>{faculty.title}</td>
                            <td><button className="btn btn-sm btn-primary" onClick={() => handleUpdate(faculty.id)}>Update</button></td>
                            <td><button className="btn btn-sm btn-danger" onClick={() => handleDelete(faculty.id)}>Delete</button></td>
                            </tr>
                        ))
                        }
                    </tbody>
                    </table>
                </div>
            </div>
        </>
     );
}
 
export default FacultyList;