package springcourse.crudstudent.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springcourse.crudstudent.model.Student;

public interface StudentServiceInterface {
    public Student findById(Long id);
    public Page<Student> findAll(Pageable pageable);
    public Student save(Student student);
    public void update(Student student);
    public void delete(Long id);
}

