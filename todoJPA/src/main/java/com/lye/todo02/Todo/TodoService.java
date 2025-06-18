package com.lye.todo02.Todo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // insert
    public void insert(TodoDto dto) {
        TodoEntity entity = toEntity(dto);
        entity.setComplete(false);
        // 여기서 guestId별 no 값 증가
        Long count = todoRepository.countByGuestId(dto.getGuestId());
        entity.setNo(count + 1);
        todoRepository.save(entity);
    }

    // All list
    public List<TodoEntity> list(String guestId) {
        return todoRepository.findByGuestId(guestId);
    }

    // complete
    public void completed(Long id, boolean complete) {
        TodoEntity dbEntity = todoRepository.findById(id).orElse(null);
        if(dbEntity != null){
            dbEntity.setComplete(!dbEntity.isComplete());
        }
    }

    // delete
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // DTO -> Entity
    private TodoEntity toEntity(TodoDto dto){
        TodoEntity entity = new TodoEntity();
        entity.setNo(dto.getNo());
        entity.setGuestId(dto.getGuestId());
        entity.setContent(dto.getContent());
        entity.setComplete(dto.isComplete());
        return entity;
    }

    // Entity -> DTO
    private TodoDto todto(TodoEntity entity){
        TodoDto dto = new TodoDto();
        dto.setNo(entity.getNo());
        dto.setGuestId(entity.getGuestId());
        dto.setContent(entity.getContent());
        dto.setComplete(entity.isComplete());
        return dto;
    }
}
