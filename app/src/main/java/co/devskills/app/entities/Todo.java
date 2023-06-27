package co.devskills.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(indexes = @Index(name = "fn_index", columnList = "description, priority"))
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Date dueDate;

    @NotNull
    private Integer priority;

    public Date getDueDate() {
        return dueDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
