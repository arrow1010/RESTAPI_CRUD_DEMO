package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.StudentService;
import com.student.dto.StudentDTO;


@RestController
@RequestMapping(value = "/studentApp")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//get list of all students
	@GetMapping("/")
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		List<StudentDTO> ls = studentService.getAllStudents();
		return new ResponseEntity<>(ls, HttpStatus.OK);
	}

	//get student by Id
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer studentId) throws Exception{
		StudentDTO ls = studentService.getStudentById(studentId);
		return new ResponseEntity<>(ls, HttpStatus.OK);
	}
	
	//add new student
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) throws Exception{
		System.out.println("hello world ..........");
		Integer studentId = studentService.addStudent(studentDTO);
		return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
	}
	
	//delete student by id
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId)throws Exception{
		studentService.deleteStudent(studentId);
		return new ResponseEntity<>("Student Deleted Successfully", HttpStatus.OK);
	}
	
	//update student's name using id
	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<String> updatedStudent(@PathVariable Integer studentId, @RequestBody StudentDTO studentDTO)throws Exception{
		studentService.updateStudentName(studentId, studentDTO.getName());
		return new ResponseEntity<>("Student Updated Successfully", HttpStatus.OK);
	}
	
}
