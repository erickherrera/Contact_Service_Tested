package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.Task; // Import statement for the Contact class

public class TaskTest {
	//Testing Class element exceptions are working
		@Test
		void testTaskClass() {
			Task taskClass = new Task("042395", "Task Test", "This is the description of the task");
			// Task ID element positive / negative checks
			assertTrue(taskClass.getTaskID().length()<10);
		    assertNotNull(taskClass.getTaskID());

			//Task name element positive / negative checks
			assertTrue(taskClass.getTaskName().length()<20);
		    assertNotNull(taskClass.getTaskName());

			//Task description element positive / negative checks
			assertTrue(taskClass.getTaskDescription().length()<50);
		    assertNotNull(taskClass.getTaskDescription());
			
		}
		
		@Test
		void testTaskIdTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("12345678910", "", "");
			});
		}
		
		@Test
		void testTaskNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("blank", "Task Name needs to be < 20 characters", "blank");
			});
		}
		
		@Test
		void testTaskDescriptionTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("", "", "Toooooooooooooooooooooooooooooooo Looooooooooooooooong");
			});
		}
		
}
