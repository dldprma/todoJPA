package com.lye.todo02.Todo;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // 일정 작성하기
    @Operation(summary = "할 일 추가", description = "새로운 todo 생성")
    @PostMapping
    public void insert(@RequestBody TodoDto dto){
        todoService.insert(dto);
    }

    // 일정 조회
    @Operation(summary = "할 일 조회", description = "guestId별 조회")
    @GetMapping("{guestId}")
    public List<TodoEntity> list(@PathVariable String guestId){
        return todoService.list(guestId);
    }

    // 일정 완료
    @Operation(summary = "할 일 완료 변경", description = "완료 표시 변경")
    @PutMapping("{id}")
    public void completed(@PathVariable Long id, boolean complete){
        todoService.completed(id, complete);
    }

    // 일정 삭제
    @Operation(summary = "할 일 삭제", description = "할 일 삭제")
    @DeleteMapping("delete/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }


}
