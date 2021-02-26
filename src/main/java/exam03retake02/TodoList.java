package exam03retake02;

import java.util.*;

public class TodoList {

  private List<Todo> todos = new ArrayList<>();

  public void addTodo(Todo todo) {
    todos.add(todo);
  }

  public int getNumberOfItemsLeft() {
    int result = 0;
    for (Todo todo:todos) {
      if (todo.getState() == State.NON_COMPLETED) {
        result++;
      }
    }
    return result;
  }

  public List<String> getMostImportantTodosText() {
    List<Todo> temp = new ArrayList<>(todos);
    Collections.sort(temp, new Comparator<Todo>() {
      @Override
      public int compare(Todo o1, Todo o2) {
        return o1.getPriority() - o2.getPriority();
      }
    });
    List<String> result = createListMostImportantTodos(temp);
    return result;
  }

  private List<String> createListMostImportantTodos(List<Todo> temp) {
    List<String> result = new ArrayList<>();
    int maxPriority = temp.get(0).getPriority();
    for (Todo tempTodo : temp) {
      if (tempTodo.getPriority() == maxPriority) {
        result.add(tempTodo.getText());
      }
    }
    return result;
  }


  public void deleteCompleted() {
    for (int i = 0; i < todos.size(); i++) {
      if (todos.get(i).getState() == State.COMPLETED) {
        todos.remove(i);
      }
    }
  }

  public List<Todo> getTodos() {
    return todos;
  }
}
