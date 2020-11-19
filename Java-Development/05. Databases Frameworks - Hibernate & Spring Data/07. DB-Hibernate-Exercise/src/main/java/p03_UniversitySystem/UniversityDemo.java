package p03_UniversitySystem;

import p03_UniversitySystem.entities.Course;
import p03_UniversitySystem.entities.Student;
import p03_UniversitySystem.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;

public class UniversityDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("university");
        EntityManager entityManager = factory.createEntityManager();

        Teacher teacher = new Teacher();
        teacher.setFirstName("Mr.");
        teacher.setLastName("Johnes");
        teacher.setEmail("jj@gmail.com");

        Student student = new Student();
        student.setFirstName("Pesho");
        student.setLastName("Peshev");
        student.setCourses(new HashSet<>());

        Student otherStudent = new Student();
        student.setFirstName("Gosho");
        student.setLastName("Goshev");
        student.setCourses(new HashSet<>());

        Course course = new Course();
        course.setName("Java");
        course.setDescription("The course will be 8 hours/week");
        course.setStartDate(new Date());
        course.setTeacher(teacher);
        course.setStudents(new HashSet<>());

        course.getStudents().add(student);
        course.getStudents().add(otherStudent);

        student.getCourses().add(course);

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(teacher);
            entityManager.persist(student);
            entityManager.persist(course);

            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
