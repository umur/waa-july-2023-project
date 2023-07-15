import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useParams } from 'react-router-dom';
import Swal from 'sweetalert2'


const StudentUpdate = () => {
    const entity = "student";

    const { id } = useParams();
    const [student, setStudent] = useState(null);

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [cv, setCv] = useState('');
    const [isCurrentlyEmployed, setIsCurrentlyEmployed] = useState('');
    const [isPending, setIsPending] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const getStudent = async () => {
            const result = await axios.get(`/students/${id}`);
            setStudent(result.data);
            setFirstName(result.data.firstName);
            setLastName(result.data.lastName);
            setEmail(result.data.email);
            setPhone(result.data.phone);
            setCv(result.data.cv);
            setIsCurrentlyEmployed(result.data.isCurrentlyEmployed);
        }
        getStudent();
    },[id])

    const handleStudentUpdate = async (e) => {
        e.preventDefault();
        setIsPending(true);

        try {
            const updatedStudent = { firstName, lastName, email, phone, cv, isCurrentlyEmployed };
            await updateCourse(updatedStudent);
            Swal.fire(
                'Success!',
                `The ${entity} has been updated successfully.`,
                'success'
            )
            navigate("/");
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: `An error occurred while updating the ${entity}, please try again`,
            })
            console.error(error);
        } finally {
            setIsPending(false);
        }
    }

    const updateCourse = async (updatedStudent) => {
        await axios.put(`/students/${id}`, updatedStudent);
    }

    return ( 
        <>
            {student && <div className="container">
                <h2>Update Course</h2>

                <div className="mt-5">

                <form id="updateCourseForm" onSubmit={handleStudentUpdate}>
                    <input type="hidden" id="updateStudentId" value={student.id} />

                    <div className="mb-3">
                        <label htmlFor="firstNameInput" className="form-label">First Name</label>
                        <input type="text" className="form-control" id="firstNameInput" value={firstName} onChange={e => setFirstName(e.target.value)} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lastNameInput" className="form-label">Last Name</label>
                        <input type="text" className="form-control" id="lastNameInput" value={lastName} onChange={e => setLastName(e.target.value)} />
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="emailInput" className="form-label">Email</label>
                        <input type="text" className="form-control" id="emailInput" value={email} onChange={e => setEmail(e.target.value)} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="phoneInput" className="form-label">Phone</label>
                        <input type="text" className="form-control" id="phoneInput" value={phone} onChange={e => setPhone(e.target.value)} />
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="cvInput" className="form-label">Upload CV</label>
                        <input type="text" className="form-control" id="cvInput" value={cv} onChange={e => setCv(e.target.value)} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="employmentStatusInput" className="form-label">employment status</label>
                        <input type="text" className="form-control" id="employmentStatusInput" value={isCurrentlyEmployed} onChange={e => setIsCurrentlyEmployed(e.target.value)} />
                    </div>

                    {isPending ? 
                    <button type="submit" className="btn btn-disabled">Updating {entity}...</button> : 
                    <button type="submit" className="btn btn-primary">Update {entity}</button>}

                </form>
                </div>
            </div>}
        </>
     );
}
 
export default StudentUpdate;