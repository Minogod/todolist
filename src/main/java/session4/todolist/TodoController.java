package session4.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import session4.todolist.dto.TodoPatchDto;
import session4.todolist.dto.TodoPostDto;
import session4.todolist.dto.TodoResponseDto;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoMapper mapper;
    private final TodoService todoService;

    @Value("${service.url}")
    private String serviceUrl;

    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoPostDto todoPostDto){
        Todo todo = mapper.todoPostDtoToTodo(todoPostDto);
        Todo saveTodo = todoService.createTodo(todo);
        TodoResponseDto response = mapper.todoToTodoResponseDto(saveTodo);
        response.setServiceUrl(serviceUrl);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable long id) {
        Todo findTodo = todoService.findTodo(id);
        TodoResponseDto response = mapper.todoToTodoResponseDto(findTodo);
        response.setServiceUrl(serviceUrl);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(){
        List<Todo> todos = todoService.findTodos();
        List<TodoResponseDto> response = mapper.todosToTodoResponseDtos(todos,serviceUrl);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@PathVariable long id, @RequestBody TodoPatchDto todoPatchDto){

        Todo todo = mapper.todoPatchDtoToTodo(todoPatchDto);
        todo.setId(id);
        Todo updateTodo = todoService.updateTodo(todo);
        TodoResponseDto response = mapper.todoToTodoResponseDto(updateTodo);
        response.setServiceUrl(serviceUrl);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @DeleteMapping
    public void deleteTodos(){
        todoService.deleteTodos();
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable long id){
        todoService.deleteTodo(id);
    }
}
