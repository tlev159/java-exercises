package exam03retake02;

public class Todo {

  private String text;
  private State state;
  private int priority;

  public Todo(String text, int priority) {
    if (priority < 1 || priority > 5) {
      throw new IllegalArgumentException("Wrong priority");
    }
    this.text = text;
    this.state = State.NON_COMPLETED;
    this.priority = priority;
  }

  public void complete() {
    state = State.COMPLETED;
  }

  public String getText() {
    return text;
  }

  public State getState() {
    return state;
  }

  public int getPriority() {
    return priority;
  }

  @Override
  public String toString() {
    return "Todo{" +
            "text='" + text + '\'' +
            ", state=" + state +
            ", priority=" + priority +
            '}';
  }


}
