package com.student.service;

import java.util.List;

import com.student.dto.StudentDTO;



public interface StudentService {
	
	public List<StudentDTO> getAllStudents() ;
	public StudentDTO getStudentById(Integer studentId) throws Exception;
	public Integer addStudent(StudentDTO studentDTO) throws Exception;
	public void deleteStudent(Integer studentId) throws Exception;
	public void updateStudentName(Integer studentId, String name)throws Exception;

}
