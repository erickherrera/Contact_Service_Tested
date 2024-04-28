package taskservice;
import java.util.HashMap;
import java.util.Map;
import task.Task;

public class TaskService {
private final Map<String, Task> tasks = new HashMap<>();
	
	public boolean addTask(Task task) {
		if(task == null || tasks.containsKey(task.getTaskID())) {
			return false;
		}
		tasks.put(task.getTaskID(), task);
		return true;
	}
	
	public boolean deleteContact(String id) {
		if(tasks.containsKey(id)) {
			tasks.remove(id);
			return true;
		}
		return false;
	}
	
	public boolean updateTask(String id, String taskName, String taskDescription) {
		if(!tasks.containsKey(id)) {
			return false;
		}
		Task taskToUpdate = tasks.get(id);
	    if (taskName != null && !taskName.isEmpty()) taskToUpdate.setTaskName(taskName);
	    if (taskDescription != null && !taskDescription.isEmpty()) taskToUpdate.setTaskDescription(taskDescription);;
	    return true;
	}
}
