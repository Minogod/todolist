package session4.todolist.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TodoPatchDto {
    private Long id;
    private String title;
    private int order;
    private boolean completed;


}
