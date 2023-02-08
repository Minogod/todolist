package session4.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    public Todo updateTodo(Todo todo) {
        Optional<Todo> byId = todoRepository.findById(todo.getId());
        Todo dbTodo = byId.orElseThrow(() -> new RuntimeException("아이디가없습니다."));

        Optional.ofNullable(todo.getTitle()).ifPresent(dbTodo::setTitle);
        Optional.of(todo.getOrder()).ifPresent(dbTodo::setOrder);
        Optional.of(todo.isCompleted()).ifPresent(dbTodo::setCompleted);

        return todoRepository.save(dbTodo);

    }
    public Todo findTodo(long todoId) {
        Optional<Todo> byId = todoRepository.findById(todoId);
        return byId.orElseThrow(() -> new RuntimeException("아이디가없습니다."));
    }
    public List<Todo> findTodos() {
        List<Todo> all = todoRepository.findAll();
        return all;
    }
    public void deleteTodo(long todoId) {
        todoRepository.deleteById(todoId);
    }

    public void deleteTodos() {
        todoRepository.deleteAll();
    }
}
