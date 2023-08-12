package com.example.alumni.service.impl;


import com.example.alumni.entity.StudentComment;
import com.example.alumni.repository.StudentCommentRepository;
import com.example.alumni.service.StudentCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentCommentServiceImpl implements StudentCommentService {

    @Autowired
    private StudentCommentRepository studentCommentRepository;

    @Override
    public Iterable<StudentComment> getAll() {
        return studentCommentRepository.findAll();
    }

    @Override
    public StudentComment getById(Long id) {
        return studentCommentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentComment add(StudentComment studentComment) {
        return studentCommentRepository.save(studentComment);
    }

    @Override
    public Pair<Boolean, StudentComment> update(StudentComment studentComment) {
        boolean exists = studentCommentRepository.existsById(studentComment.getId());
        studentComment = studentCommentRepository.save(studentComment);
        return Pair.of(exists, studentComment);
    }

    @Override
    public boolean delete(Long id) {
        StudentComment existingStudentComment = studentCommentRepository.findById(id).orElse(null);
        if (existingStudentComment != null) {
            studentCommentRepository.delete(existingStudentComment);
            return true;
        }
        return false;
    }
}
