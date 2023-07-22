import React from "react";

import { useState, useEffect } from "react";

import axios from "axios";

export default function AllComments() {
  const [comments, setComments] = useState([]);

  useEffect(() => {
    fetchComments();
  }, []);

  const fetchComments = async () => {
    try {
      const response = await axios.get("http://localhost:8080/comments");

      setComments(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h5 className="mb-4">List Of Comments</h5>

      <table className="table table-striped table-bordered">
        <thead className="bg-info text-white">
          <tr>
            <th>Comment</th>
            <th>Student</th>
          </tr>
        </thead>

        <tbody>
          {comments.map((comment) => (
            <tr key={comment.id}>
              <td>{comment.comment}</td>
              <td>{comment.student}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
