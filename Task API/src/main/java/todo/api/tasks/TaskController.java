package todo.api.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Query to fetch all tasks
    @QueryMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Query to fetch a task by ID
    @QueryMapping
    public Task getTaskById(@Argument Long id) {
        return taskService.getTaskById(id);
    }

    // Mutation to create a new task
    @MutationMapping
    public Task createTask(@Argument String title, @Argument String description) {
        Task newTask = new Task();
        newTask.setTitle(title);
        newTask.setDescription(description);
        return taskService.createTask(newTask);
    }

    // Mutation to update a task by ID
    @MutationMapping
    public Task updateTask(@Argument Long id, @Argument String title, @Argument String description) {
        Task updatedTask = new Task();
        updatedTask.setTitle(title);
        updatedTask.setDescription(description);
        return taskService.updateTask(id, updatedTask);
    }

    // Mutation to delete a task by ID
    @MutationMapping
    public String deleteTask(@Argument Long id) {
        taskService.deleteTask(id);
        return "Task with ID " + id + " deleted successfully!";
    }
}
