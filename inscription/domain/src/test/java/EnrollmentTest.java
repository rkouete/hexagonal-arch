import com.tech4life.domain.model.Clazz;
import com.tech4life.domain.model.Enrollment;
import com.tech4life.domain.model.Student;
import com.tech4life.domain.port.out.Students;
import com.tech4life.domain.serviceadapter.EnrollmentCoordinatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class EnrollmentTest {

    @Mock
    Students students;
    @InjectMocks
    EnrollmentCoordinatorImpl enrollmentCoordinator;

    Student student = new Student("1", "John", "Doe");
    Clazz clazz = new Clazz("6ème 1");

    @Test
    void testEnroll(){
        Enrollment enrollment = enrollmentCoordinator.enroll(student, clazz);
        assertEquals(student.firstName(), enrollment.student().firstName());
        assertEquals(student.lastName(), enrollment.student().lastName());
        assertEquals(clazz, enrollment.clazz());
    }
}
