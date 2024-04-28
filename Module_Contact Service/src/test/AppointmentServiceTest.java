package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import appointmentservice.AppointmentService;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
	 private AppointmentService appointmentService;
	 private Date futureDate;

	  @BeforeEach
	  void setUpService() {
		  appointmentService = new AppointmentService();
	      futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
	  }

	  @Test
	  void addAppointmentValidData() {
	      appointmentService.addAppointment("01", futureDate, "Appointment #1");
	      assertNotNull(appointmentService);
	  }

	  @Test
	  void addAppointmentDuplicateId() {
	      appointmentService.addAppointment("01", futureDate, "Appointment #1");
	      assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("01", futureDate, "Appointment #2"));
	  }

	  @Test
	   void addAppointmentNullId() {
	      assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(null, futureDate, "Appointment #1"));
	   }

	  @Test
	  void deleteNonExistingAppointment() {
	      assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("Does not exist"));
	  }

	  @Test
	  void deleteAppointmentNullId() {
	      assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment(null));
	   }
}
