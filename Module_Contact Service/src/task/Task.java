package task;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDescription;
	
	public Task(String id, String taskName, String taskDescription) {
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Task name too long");
		}
		if(taskDescription == null || taskDescription.length()>50) {
			throw new IllegalArgumentException("Task Description too long.");
		}
		this.taskID = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	public String getTaskID() {
		return taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
}
