package com.bornfire.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	// api to create a string
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "HELLO WORLD";

	}

	// api to create single json obj
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("pasupathi", "vaigai");

	}

	// api to create list of json obj
	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		students.add(new Student("pasupathi", "vaigai"));
		students.add(new Student("inian", "trinelveli"));
		students.add(new Student("ashok", "perambalur"));
		students.add(new Student("maha", "vellur"));
		students.add(new Student("kaviarasu", "darmapuri"));

		return students;

	}

	// api to handle pathVariable
	@GetMapping("/student/{name}/{address}")
	public Student pathVariable(@PathVariable("name") String name, @PathVariable("address") String address) {
		return new Student(name, address);

	}

	// api to handle query parameter
	@GetMapping("/students/query")
	public Student studentQueryParam(@RequestParam(name = "name") String name,
			@RequestParam(name = "address") String address) {
		return new Student(name, address);

	}

}
