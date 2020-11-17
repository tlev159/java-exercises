package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoListMain {

  public static void main(String[] args) {

    TodoList todoList = new TodoList();

    todoList.addTodo("Bevásárlás");
    todoList.addTodo("Tanulás");
    todoList.addTodo("Programozás");
    todoList.addTodo("Házi feladatok elvégzése");
    todoList.addTodo("Lecke tanulása");
    todoList.addTodo("Tanulás");
    todoList.addTodo("Vacsorakészítés");

    System.out.println(todoList);

    System.out.println("elvégzett feladatok: " + todoList.numberOfFinishedTodos());
    System.out.println(todoList.todosToFinish());

    todoList.finishTodos("Tanulás");

    System.out.println(todoList.todosToFinish());
    System.out.println("elvégzett feladatok száma: " + todoList.numberOfFinishedTodos());

    todoList.finishAllTodos(Arrays.asList("Bevásárlás", "Lecke tanulása"));

    System.out.println(todoList.todosToFinish());
    System.out.println(todoList.numberOfFinishedTodos());

  }
}
