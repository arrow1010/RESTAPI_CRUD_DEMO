package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dto.StudentDTO;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service(value="studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDTO> getAllStudents() {
		Iterable<Student> its = studentRepository.findAll();
		List<StudentDTO> lsd = new ArrayList<>();
		its.forEach(x->{
			System.out.println(x.getEmail());
			StudentDTO sd = new StudentDTO();
			sd.setEmail(x.getEmail());
			sd.setName(x.getName());
			sd.setStudentId(x.getStudentId());
			lsd.add(sd);
		});
		return lsd;
	}

	@Override
	public StudentDTO getStudentById(Integer studentId) throws Exception {
		Optional<Student> op = studentRepository.findById(studentId);
		Student st = op.orElseThrow(()->new Exception("No student with such id"));
		StudentDTO stt = new StudentDTO();
		stt.setEmail(st.getEmail());
		stt.setName(st.getName());
		stt.setStudentId(st.getStudentId());
		return stt;
	}

	@Override
	public Integer addStudent(StudentDTO studentDTO) throws Exception {
		Student s = new Student();
		s.setEmail(studentDTO.getEmail());
		s.setName(studentDTO.getName());
		s.setStudentId(studentDTO.getStudentId());
	    Student s2 = studentRepository.save(s);
	    return s2.getStudentId();
	}

	@Override
	public void deleteStudent(Integer studentId) throws Exception {
		Optional<Student> op = studentRepository.findById(studentId);
		Student st = op.orElseThrow(()->new Exception("No student with such id"));
		studentRepository.deleteById(studentId);
		
	}

	@Override
	public void updateStudentName(Integer studentId, String name) throws Exception {
		Optional<Student> op = studentRepository.findById(studentId);
		Student st = op.orElseThrow(()->new Exception("No student with such id"));
		st.setName(name);
		
	}
	
	

}
