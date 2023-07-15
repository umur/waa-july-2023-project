const StudentList = ({ students, title, handleUpdate, handleDelete}) => {
    const baseUrl = "http://localhost:3000";

    const constructDownloadLink = (fileName) => {
        return `${baseUrl}/downloads${fileName}`;
    };

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
                        <th scope="col">CV</th>
                        <th scope="col">Employed?</th>
                        <th scope="col">Deleted?</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                        students.map(student => (
                            <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.email}</td>
                            <td>{student.phone}</td>
                            {/* <td><a href={student.cv} download>Download</a></td> */}
                            <td><a href={constructDownloadLink(student.cv)} download={`${student.firstName}-${student.lastName}-CV.pdf`}>Download</a></td>
                            <td>{student.currentlyEmployed.toString()}</td>
                            <td>{student.deleted.toString()}</td>
                            <td><button className="btn btn-primary" onClick={() => handleUpdate(student.id)}>Update</button></td>
                            <td><button className="btn btn-danger" onClick={() => handleDelete(student.id)}>Delete</button></td>
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
 
export default StudentList;