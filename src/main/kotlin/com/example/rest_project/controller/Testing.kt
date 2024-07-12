import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class TaskController {

    // Sample list of tasks
    var tasks: MutableList<Task> = mutableListOf(
        Task(1, "Task 1", "Pending"),
        Task(2, "Task 2", "Completed"),
        Task(3, "Task 3", "Pending")
    )

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("tasks", tasks)
        return "Secondary"
    }

    @PostMapping("/deleteUncheckedTasks")
    fun deleteUncheckedTasks(@ModelAttribute("tasks") tasks: List<Task>): String {
        this.tasks.removeIf { task -> !tasks.contains(task) }
        return "redirect:/"
    }

    data class Task(val id: Long, val name: String, val status: String, var checked: Boolean = false)
}
