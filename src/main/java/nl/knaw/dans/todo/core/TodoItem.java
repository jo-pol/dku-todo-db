package nl.knaw.dans.todo.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoItem {

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  long id;

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  String task;
}
