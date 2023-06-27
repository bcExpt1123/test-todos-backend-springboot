package co.devskills.app.repository;

import co.devskills.app.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Page<Todo> findByDescriptionContaining(String description, Pageable pageable);
    Page<Todo> findByPriorityAndDescriptionContaining(Integer priority, String description, Pageable pageable);
}
