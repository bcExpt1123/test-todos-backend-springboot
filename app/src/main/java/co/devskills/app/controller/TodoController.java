package co.devskills.app.controller;

import co.devskills.app.entities.Todo;
import co.devskills.app.model.Pagination;
import co.devskills.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/todos")
    public Page<Todo> getAllTodos(@Valid @RequestParam(value = "page", defaultValue = "1") Integer current, @Valid @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @Valid @RequestParam(value = "description", defaultValue = "") String keyword, @Valid @RequestParam(value = "priority", defaultValue = "-1") Integer priority) {
        if(pageSize  == 0)
            pageSize = 10;
        current = current - 1;
        if(current < 0) {
            current = 0;
        }
        Pagination pagination = new Pagination();
        pagination.setCurrent(current);
        pagination.setPageSize(pageSize);
        return todoService.getTodoAllByPagination(pagination, keyword, priority);
    }


    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }


    @PatchMapping("/todos/{id}")
    public Todo updateTodo(@Valid @PathVariable(value = "id") Long todoId,@Valid @RequestBody Todo todo) {
        return todoService.updateTodo(todoId, todo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@Valid @PathVariable(value = "id") Long todoId) {
        return todoService.deleteTodo(todoId);
    }
}
