package com.example.elastic.springelasticdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repository;

    @PostMapping("/student/all")
    public Student addStudent(@RequestBody Student student){
        return repository.save(student);
    }


    @GetMapping("/student/all")
    public List<Student> getStudents(){
        Iterator<Student> iterator = repository.findAll().iterator();
        List<Student> students = new ArrayList<Student>();
        while (iterator.hasNext()){
            students.add(iterator.next());
        }
        return students;
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return repository.findById(id);
    }

}
