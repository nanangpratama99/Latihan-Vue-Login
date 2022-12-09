package com.example.students.repository;

import java.util.List;

import com.example.students.model.Students;

public interface IStudentsRepository {
    public Students insertStudents(Students students);

    public List<Students> getAllStudents();

    public Students updateStudents(int id, Students students);

    public Students deleteStudents(int id);

    public Students getStudents(int id);

    public Students loginStudent(String email, String jenis_kelamin);

}
