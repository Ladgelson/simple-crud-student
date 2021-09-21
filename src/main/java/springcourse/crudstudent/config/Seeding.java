package springcourse.crudstudent.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springcourse.crudstudent.model.Student;
import springcourse.crudstudent.repository.StudentRepository;

import java.util.List;

@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class Seeding implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student(null, "Júlio Andrade", 25L, "julio_andrade@gmail.com");
        Student s2 = new Student(null, "Júlia Fernandes", 25L, "jufer@gmail.com");
        Student s3 = new Student(null, "Dávila Lopes", 25L, "davilalopesgurgel@gmail.com");
        Student s4 = new Student(null, "Hatus Gabriel", 25L, "hatus@gmail.com");
        Student s5 = new Student(null, "Romulo Goré", 25L, "gorefamily@gmail.com");

        studentRepository.saveAll(List.of(s1,s2,s3,s4,s5));
    }
}
