package prac12


enum class Status {
    COMPLETE,
    INCOMPLETE
}

open class Task<T>(
    val name: String,
    val description: String,
    var status: Status = Status.INCOMPLETE,
    var data: Any? = null
)

class PriorityTask(
    name: String,
    description: String,
    status: Status = Status.INCOMPLETE,
    val priority: Int = 0,
    data: Any? = null
) : Task<PriorityTask>(name, description, status, data)

fun <T> Task<T>.convertToPriorityTask(priority: Int): PriorityTask {
    return run {
        PriorityTask(this.name, this.description, this.status, priority, this.data)
    }
}

class TaskManager {
    private val tasks = mutableListOf<Task<*>>()

    fun addTask(task: Task<*>) {
        tasks.add(task)
    }

    fun removeTask(task: Task<*>) {
        tasks.remove(task)
    }

    fun changeTaskStatus(task: Task<*>, status: Status) {
        task.status = status
    }
}

fun List<Task<*>>.printTasks() {
    val priorityTasks = this.filterIsInstance<PriorityTask>()
    val nonPriorityTasks = this.filterNot { it is PriorityTask }

    val allTasks = priorityTasks + nonPriorityTasks

    println("| No | Name | Description | Status | Priority |")
    println("|----|------|-------------|--------|----------|")

    allTasks.forEachIndexed { index, task ->
        val priority = if (task is PriorityTask) task.priority else "No"
        println("| ${index + 1} | ${task.name} | ${task.description} | ${task.status} | $priority |")
    }
}


fun main() {
    val taskManager = TaskManager()
    var tasks = mutableListOf<Task<*>>()

    while (true) {
        println("1. Add task")
        println("2. Remove task")
        println("3. Change task status")
        println("4. Convert task to priority")
        println("5. Display tasks")
        println("6. Exit")

        val option = readln()

        when (option) {
            "1" -> {
                println("Enter task name:")
                val name = readln()
                println("Enter task description:")
                val description = readln()
                val task = Task<Any>(name, description)
                taskManager.addTask(task)
                tasks.add(task)
            }
            "2" -> {
                println("Enter task number to remove:")
                val number = readln().toInt()
                val task = tasks[number]
                taskManager.removeTask(task)
                tasks.removeAt(number)
            }
            "3" -> {
                println("Enter task number to change status:")
                val number = readln().toInt()
                val task = tasks[number]
                println("Enter new status (COMPLETE/INCOMPLETE):")
                val status = readln()
                taskManager.changeTaskStatus(task, Status.valueOf(status))
            }
            "4" -> {
                println("Enter task number to convert to priority:")
                val number = readln().toInt()
                val task = tasks[number]
                println("Enter priority:")
                val priority = readln().toInt()
                val priorityTask = task.convertToPriorityTask(priority)
                taskManager.removeTask(task)
                taskManager.addTask(priorityTask)
                tasks[number] = priorityTask
            }
            "5" -> {
                tasks.printTasks()
            }
            "6" -> return
            else -> println("Invalid option")
        }
    }
}
