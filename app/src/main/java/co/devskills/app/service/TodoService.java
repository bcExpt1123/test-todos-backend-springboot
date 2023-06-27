package co.devskills.app.service;

import co.devskills.app.entities.Todo;
import co.devskills.app.exception.DataNotFoundException;
import co.devskills.app.model.Pagination;
import co.devskills.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Page<Todo> getTodoAllByPagination(Pagination pagination, String keyword, Integer priority) {
        Pageable pageRequest = PageRequest.of(pagination.getCurrent(), pagination.getPageSize(), Sort.Direction.DESC, "id");
        if(priority != -1) {
            return todoRepository.findByPriorityAndDescriptionContaining(priority, keyword, pageRequest);
        }
        return todoRepository.findByDescriptionContaining(keyword, pageRequest);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long todoId, Todo todoDetail) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(DataNotFoundException::new);
        todo.setDescription(todoDetail.getDescription());
        todo.setPriority(todoDetail.getPriority());
        todo.setDueDate(todoDetail.getDueDate());

        return todoRepository.save(todo);
    }

    public ResponseEntity<?> deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(DataNotFoundException::new);
        todoRepository.delete(todo);
        return ResponseEntity.ok().build();
    }
}
