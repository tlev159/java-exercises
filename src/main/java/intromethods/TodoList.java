package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

  private List<Todo> todoList = new ArrayList<>();

   public void addTodo(String caption) {
     Todo todo = new Todo(caption);
     todoList.add(todo);
    }

    public void finishTodos(String caption) {
//     for (int i = 0; i < todoList.size(); i++) {
//       if (todoList.get(i).getCaption().equals(caption)) {
//         todoList.get(i).finish();
//       }
//     }
     for (Todo todo : todoList) {
       if (todo.getCaption().equals(caption)) {
         todo.finish();
       }
     }
    }

    public void finishAllTodos(List<String> todosToFinish) {
      for (String todoToFinish : todosToFinish) {
            finishTodos(todoToFinish);
      }
    }

    public List<String> todosToFinish() {
     List<String> whatTodosAreToFinish = new ArrayList<>();
     for (int i = 0; i < todoList.size(); i++) {
       if (todoList.get(i).isFinished() == false) {
         whatTodosAreToFinish.add(todoList.get(i).getCaption());
       }
     }
     return whatTodosAreToFinish;
    }

    public int numberOfFinishedTodos() {
     int finishedTodos = 0;
     for (Todo todo : todoList) {
        if (todo.isFinished() == true) {
          finishedTodos++;
        }
      }
     return finishedTodos;
    }

  @Override
  public String toString() {
    return todoList.toString();
  }
}
