package session4.todolist;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Value;
import session4.todolist.dto.TodoPatchDto;
import session4.todolist.dto.TodoPostDto;
import session4.todolist.dto.TodoResponseDto;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    default List<TodoResponseDto> todosToTodoResponseDtos(List<Todo> todos, String ServiceUrl){
            if ( todos == null ) {
                return null;
            }

            List<TodoResponseDto> list = new ArrayList<TodoResponseDto>( todos.size() );
            for ( Todo todo : todos ) {
                TodoResponseDto e = todoToTodoResponseDto(todo);
                e.setServiceUrl(ServiceUrl);
                list.add(e);
            }

            return list;
    }
}
