package nl.knaw.dans.todo.db;

import io.dropwizard.hibernate.AbstractDAO;
import nl.knaw.dans.todo.core.TodoItem;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class TodoItemDAO extends AbstractDAO<TodoItem> {

  public TodoItemDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
  public TodoItem create(TodoItem todoItem) {
    return persist(todoItem);
  }
  public Optional<TodoItem> findById(Long id) {
    return Optional.ofNullable(get(id));
  }
}
