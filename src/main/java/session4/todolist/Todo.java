package session4.todolist;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "todo_order")
    private int order;
    private boolean completed;
}
