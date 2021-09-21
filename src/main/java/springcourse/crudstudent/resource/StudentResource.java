package springcourse.crudstudent.resource;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springcourse.crudstudent.dto.StudentDto;
import springcourse.crudstudent.mapper.StudentMapper;
import springcourse.crudstudent.model.Student;
import springcourse.crudstudent.service.StudentService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {
    @Autowired
    private StudentService service;

    private StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @GetMapping
    public ResponseEntity<Page<Student>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentDto student) {
        return ResponseEntity.status(CREATED).body(service.save(mapper.studentDtoToStudent(student)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        service.findById(id);
        Student student = mapper.studentDtoToStudent(studentDto);
        student.setId(id);
        return ResponseEntity.ok().body(service.save(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
