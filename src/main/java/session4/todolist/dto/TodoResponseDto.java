package session4.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoResponseDto {
    private Long id;
    private String title;
    private int order;
    private boolean completed;
    private String url;

    public void setServiceUrl(String serviceUrl){
        this.url = serviceUrl+this.id;
    }

}
