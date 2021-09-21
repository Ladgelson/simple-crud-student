package springcourse.crudstudent.mapper;

import org.mapstruct.Mapper;
import springcourse.crudstudent.dto.StudentDto;
import springcourse.crudstudent.model.Student;

@Mapper
public interface StudentMapper {
    Student studentDtoToStudent(StudentDto dto);
    StudentDto studentToStudentDto(Student student);
}
