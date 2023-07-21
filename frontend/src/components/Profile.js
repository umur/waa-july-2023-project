import { Navigate } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useAuth } from '../hooks/useAuth';
import { Field, FieldArray, Form, Formik } from 'formik';
import * as Yup from 'yup';

export default function Profile(props) {
  let user = JSON.parse(localStorage.getItem('loggedInUser') || String('{}'));
  const [userData, setUserData] = useState({
    email: user.email,
    firstname: user.firstName || 'Mirzokhid',
    lastname: user.lastName || 'Ikromov',
    role: 'STUDENT',
    title: user.title,
    salary: user.salary,
    major: user.major,
    gpa: user.gpa,
    street: user.street,
    city: user.city,
    zip: user.zip,
    state: user.state,
    experience: [
      {
        company: [],
        years: [],
      },
    ],
  });
  const initialValues = {
    email: user.email,
    firstname: user.firstName || 'Mirzokhid',
    lastname: user.lastName || 'Ikromov',
    role: [user.role || 'STUDENT'],
    title: user.title,
    salary: user.salary,
    major: user.major,
    gpa: user.gpa,
    street: user.street,
    city: user.city,
    zip: user.zip,
    state: user.state,
    experience: [
      {
        company: [''],
        years: [1],
      },
    ],
  };
  const ProfileSchema = Yup.object().shape({
    firstname: Yup.string().required('Firstname is mandatory'),
    lastname: Yup.string().required('Lastname is mandatory'),
    email: Yup.string()
      .email('Invalid email')
      .required('Email is mandatory'),
    title: Yup.string().when('role', {
      is: 'FACULTY',
      then: Yup.string().required('Title is mandatory'),
    }),
    salary: Yup.number().when('role', {
      is: 'FACULTY',
      then: Yup.number().required('Salary is mandatory'),
    }),
    major: Yup.string().when('role', {
      is: 'STUDENT',
      then: Yup.string().required('Major is mandatory'),
    }),
    gpa: Yup.number().when('role', {
      is: 'STUDENT',
      then: Yup.number().required('GPA is mandatory'),
    }),
    street: Yup.string().required('Street is mandatory'),
    city: Yup.string().required('City is mandatory'),
    zip: Yup.string().required('Zip is mandatory'),
    state: Yup.string().required('State is mandatory'),
  });
  const [userErrorMessage, setUserErrorMessage] = useState('');

  useEffect(
    () => {
      console.log('userData', userData);
    },
    [userData]
  );

  const postUserData = async userData => {
    console.log(userData, 'data');
    const data = {
      id: user.id,
      email: userData.email,
      firstName: userData.firstname,
      lastName: userData.lastname,
      role: userData.role,
      title: userData.title,
      salary: userData.salary,
      major: userData.major,
      gpa: userData.gpa,
      company: userData.company,
      experience: {
        company: userData.experience.company,
        years: userData.experience.years,
      },
      address: {
        street: userData.street,
        city: userData.city,
        zip: userData.zip,
        state: userData.state,
      },
    };
    // send request
    try {
      let url = '/students';
      if (userData.role == 'FACULTY') {
        url = '/faculties';
      }
      const headers = {
        'Access-Control-Allow-Headers': '*',
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        Authorization: `Bearer ${user.accessToken}`,
      };
      const result = await axios.put(url, data, { headers });
      if (result.status > 399) {
        setUserErrorMessage('Saving user data failed');
      }
      if (result.status == 200) {
        user.email = userData.email;
        user.firstName = userData.firstname;
        user.lastName = userData.firstname;
        user.name = userData.firstname + ' ' + userData.lastname;
        user.title = userData.title;
        user.salary = userData.salary;
        user.major = userData.major;
        user.gpa = userData.gpa;
        user.street = userData.street;
        user.city = userData.city;
        user.zip = userData.zip;
        user.state = userData.state;
        localStorage.setItem('loggedInUser', JSON.stringify(user));
        props.applyUserDataChange();
        alert('User data has been saved successfully!');
      }
      console.log(result);
    } catch (e) {
      setUserErrorMessage('Saving user data failed');
    }
  };

  const authed = useAuth();

  // we need also add authorization check
  if (authed != true) {
    return <Navigate to="/sign-in" replace />;
  }

  return (
    <div className="regArea container py-5">
      <h3>
        {userData.firstname} {userData.lastname}'s profile
      </h3>
      <h5 className="error text-danger">{userErrorMessage}</h5>
      <Formik
        initialValues={initialValues}
        validationSchema={ProfileSchema}
        onSubmit={postUserData}
        render={({ values, errors }) => {
          return (
            <Form>
              <div className="row">
                <div className="col-md-10 mx-auto">
                  <div className="form-group row">
                    <div className="col-sm-6">
                      <label>First name</label>
                      <Field
                        name="firstname"
                        type="text"
                        className="form-control"
                        placeholder="First name"
                      />
                      {errors.firstname && (
                        <div className="error text-danger">{errors.firstname}</div>
                      )}
                    </div>
                    <div className="col-sm-6">
                      <label>Last name</label>
                      <Field
                        name="lastname"
                        type="text"
                        className="form-control"
                        placeholder="Last name"
                      />
                      {errors.lastname && (
                        <div className="error text-danger">{errors.lastname}</div>
                      )}
                    </div>
                  </div>
                  <div className="form-group row">
                    <div className="col-sm-6">
                      <label>Email address</label>
                      <Field
                        name="email"
                        type="email"
                        className="form-control"
                        placeholder="Enter email"
                      />
                      {errors.email && <div className="error text-danger">{errors.email}</div>}
                    </div>
                    <div className="col-sm-6">
                      <label>Student/Faculty</label>
                      <Field
                        as="select"
                        disabled="true"
                        className="form-control"
                        placeholder="Faculty/Student"
                        name="role[0]">
                        <option value="FACULTY">Faculty</option>
                        <option value="STUDENT">Student</option>
                      </Field>
                      {errors.role && <div className="error text-danger">{errors.role}</div>}
                    </div>
                  </div>
                  <div className="form-group row">
                    {userData.role == 'FACULTY' ? (
                      <div className="col-sm-6">
                        <label>Title</label>
                        <Field
                          name="title"
                          type="text"
                          className="form-control"
                          placeholder="Title"
                        />
                        {errors.title && <div className="error text-danger">{errors.title}</div>}
                      </div>
                    ) : (
                      <div className="col-sm-6">
                        <label>Major</label>
                        <Field
                          name="major"
                          type="text"
                          className="form-control"
                          placeholder="Major"
                        />
                        {errors.major && <div className="error text-danger">{errors.major}</div>}
                      </div>
                    )}
                    {userData.role == 'FACULTY' ? (
                      <div className="col-sm-6">
                        <label>Salary</label>
                        <Field
                          name="salary"
                          type="text"
                          className="form-control"
                          placeholder="Salary"
                        />
                        {errors.salary && <div className="error text-danger">{errors.salary}</div>}
                      </div>
                    ) : (
                      <div className="col-sm-6">
                        <label>GPA</label>
                        <Field name="gpa" type="text" className="form-control" placeholder="Gpa" />
                        {errors.gpa && <div className="error text-danger">{errors.gpa}</div>}
                      </div>
                    )}
                  </div>
                  <div className="form-group row">
                    <div className="col-sm-6">
                      <label>Street</label>
                      <Field
                        name="street"
                        type="text"
                        className="form-control"
                        placeholder="Street"
                      />
                      {errors.street && <div className="error text-danger">{errors.street}</div>}
                    </div>
                    <div className="col-sm-6">
                      <label>City</label>
                      <Field name="city" type="text" className="form-control" placeholder="City" />
                      {errors.city && <div className="error text-danger">{errors.city}</div>}
                    </div>
                  </div>
                  <div className="form-group row">
                    <div className="col-sm-6">
                      <label>Zip</label>
                      <Field name="zip" type="text" className="form-control" placeholder="Zip" />
                      {errors.zip && <div className="error text-danger">{errors.zip}</div>}
                    </div>
                    <div className="col-sm-6">
                      <label>State</label>
                      <Field
                        name="state"
                        type="text"
                        className="form-control"
                        placeholder="state"
                      />
                      {errors.state && <div className="error text-danger">{errors.state}</div>}
                    </div>
                  </div>

                  {userData.role === 'STUDENT' && (
                    <div className="form-group row mt-3">
                      <FieldArray
                        name="experience"
                        render={arrayHelpers => (
                          <div>
                            <h3>Experience</h3>
                            {values.experience.map((exp, index) => (
                              <div key={index}>
                                <div className="row mt-3">
                                  <div className="col-sm-6">
                                    <label>Company Name</label>
                                    <Field
                                      name={`experience[${index}].company`}
                                      type="text"
                                      className="form-control"
                                      placeholder="Company"
                                    />
                                  </div>
                                  <div className="col-sm-6">
                                    <label>Years of experience</label>
                                    <Field
                                      name={`experience[${index}].years`}
                                      type="number"
                                      className="form-control"
                                      placeholder="Years of experience"
                                    />
                                  </div>
                                  <div className="mt-2">
                                    <button
                                      type="button"
                                      className="btn btn-warning mr-3"
                                      onClick={() =>
                                        arrayHelpers.push(index, { company: '', years: 0 })
                                      }>
                                      Add
                                    </button>
                                    <button
                                      type="button"
                                      className="btn btn-danger ms-2"
                                      onClick={() => arrayHelpers.remove(index)}>
                                      Remove
                                    </button>
                                  </div>
                                </div>
                              </div>
                            ))}
                          </div>
                        )}
                      />
                    </div>
                  )}
                  <div className="form-group row">
                    <div className="col-sm-6" />
                    <div className="col-sm-6">
                      <button onSubmit={postUserData} className="mybtn btn btn-primary">
                        Save
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </Form>
          );
        }}
      />
    </div>
  );
}
