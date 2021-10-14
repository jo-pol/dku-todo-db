package nl.knaw.dans.todo.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;
import nl.knaw.dans.todo.core.TodoItem;
import nl.knaw.dans.todo.db.TodoItemDAO;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// placed here as in the hello-world exercise,
// the dropwizard example placed these annotations at the method
@Path("/todo")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
// @Produces(MediaType.TEXT_HTML) // variation on dropwizard example: marked unstable
public class TodoItemResource {

  private final TodoItemDAO todoItemDAO;

  public TodoItemResource(TodoItemDAO todoItemDAO) {
    this.todoItemDAO = todoItemDAO;
  }

  @POST
  @UnitOfWork
  public TodoItem create(@Valid TodoItem todoItem) {
    return todoItemDAO.create(todoItem);
  }

  @GET
  @Timed
  public TodoItem get(@PathParam("id") long id) {
    return todoItemDAO.findById(id).orElseThrow(() -> new NotFoundException("could not fin todo id: "+ id));
  }
}
