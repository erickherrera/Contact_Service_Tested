package test;
import org.junit.jupiter.api.Test;
import appointment.Appointment;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
	@Test
	void testAppointmentConstructorValidData() {
		Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
		Appointment newAppointment = new Appointment("01", futureDate, "Dentist Appointment");
		assertNotNull(newAppointment);
		assertNotNull(futureDate);
		assertEquals("01", newAppointment.getAppointmentId());
		assertEquals(futureDate, newAppointment.getAppointmentDate());
		assertEquals("Dentist Appointment", newAppointment.getDescription());
	}
	
	@Test
	void testAppointmentInvalidId() {
		Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Dentist Appointment"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678910", futureDate, "Dentist Appointment"));
	}
	
	@Test
	void testAppointmentInvalidDate() {
		Date pastDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("00", pastDate, "Dentist Appointment"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("00", null, "Dentist Appointment"));
	}
	
	@Test
	void testAppointmentInvalidDescription() {
		Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("00", futureDate, String.format("%0" + 51 + "d", 0)));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("00", futureDate, null ));
	}
	
	@Test
    void testSetAppointmentDateValid() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 1 day in the future
        Appointment appointment = new Appointment("01", futureDate, "Dentist Appointment");
        Date newFutureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48); // 2 days in the future
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    @Test
    void testSetAppointmentDateInvalid() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 1 day in the future
        Appointment appointment = new Appointment("01", futureDate, "Dentist Appointment");
        Date pastDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24); // 1 day in the past
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
    }

    @Test
    void testSetDescriptionValid() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 1 day in the future
        Appointment appointment = new Appointment("01", futureDate, "Dentist Appointment");
        appointment.setDescription("Orthodontist Appointment");
        assertEquals("Orthodontist Appointment", appointment.getDescription());
    }

    @Test
    void testSetDescriptionInvalid() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 1 day in the future
        Appointment appointment = new Appointment("01", futureDate, "Dentist Appointment");
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(String.format("%0" + 51 + "d", 0)));
    }
}
