package springcourse.crudstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springcourse.crudstudent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
