package com.example.todolist;

import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("To-Do List:");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the task: ");
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.println("Enter the number of the task to complete:");
                    List<Task> tasks = taskManager.getTasks();
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    taskManager.completeTask(taskNumber - 1);
                    System.out.println("Task completed.");
                    break;
                case 3:
                    System.out.println("Your tasks:");
                    List<Task> currentTasks = taskManager.getTasks();
                    for (int i = 0; i < currentTasks.size(); i++) {
                        System.out.println((i + 1) + ". " + currentTasks.get(i));
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
