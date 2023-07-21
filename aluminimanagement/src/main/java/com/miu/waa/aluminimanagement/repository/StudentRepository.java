package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.model.StudentPerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByAddress_StateIgnoreCase(String state);

    List<Student> findByAddress_StateIgnoreCaseAndAddress_CityIgnoreCase(String state, String city);

    List<Student> findByMajorContainingIgnoreCase(String major);

    List<Student> findByFirstnameContaining(String name);

    List<Student> findByUniversityId(int universityId);

    @Query(value =
            "SELECT "+
                    " new com.miu.waa.aluminimanagement.model.StudentPerState(count(s.id),s.address.state)" +
                    "FROM Student s inner join Address as a on s.address.id=a.id " +
                    "GROUP By s.address.state"
    )
    List<StudentPerState> noOfJobsPerState();
}
