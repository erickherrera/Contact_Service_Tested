package appointmentservice;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import appointment.Appointment;

public class AppointmentService {
	private final Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	public void addAppointment(String appointmentId, Date appointmentDate, String description) {
		if(appointmentId == null || appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID must be unique and not null.");
		}
		Appointment newAppointment = new Appointment(appointmentId,appointmentDate, description );
		appointments.put(appointmentId, newAppointment);
	}
	
	 public void deleteAppointment(String appointmentId) {
	        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
	            throw new IllegalArgumentException("Appointment ID does not exist");
	        }
	        
	        appointments.remove(appointmentId);
	    }

}
