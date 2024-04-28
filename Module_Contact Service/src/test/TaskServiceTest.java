package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskservice.TaskService;
import task.Task;

class TaskServiceTest {
	private TaskService taskService;
    private Task task;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
        task = new Task("00000001", "Task #1", "This is the first task.");
        taskService.addTask(task); 
    }

    @Test
    void testAddTaskSuccessfully() {
        Task newTask = new Task("00000002", "Task #2", "This is the first task.");
        assertTrue(taskService.addTask(newTask), "Task should be added successfully");
    }

    @Test
    void testAddTaskFailDueToDuplicateId() {
        // Attempting to add a contact with an existing ID
        Task duplicateIdTask = new Task("00000001", "Task #1", "This is a duplicate of the first task.");
        assertFalse(taskService.addTask(duplicateIdTask), "Task should not be added due to duplicate ID");
    }

    @Test
    void testAddTaskFailDueToNullTask() {
        assertFalse(taskService.addTask(null), "Task should not be added because it is null");
    }

    @Test
    void testDeleteTaskSuccessfully() {
        assertTrue(taskService.deleteContact(task.getTaskID()), "Task should be deleted successfully");
    }

    @Test
    void testUpdateContactSuccessfully() {
        assertTrue(taskService.updateTask("00000001", "Task #1", "This is a UPDATE of the first task."), "Task should be updated successfully");
    }
}
