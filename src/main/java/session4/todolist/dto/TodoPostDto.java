package session4.todolist.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@ToString
public class TodoPostDto {
    private Long id;
    private String title;
    private int order;
    private boolean completed;


}
