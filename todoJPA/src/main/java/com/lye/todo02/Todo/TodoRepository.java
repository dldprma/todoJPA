package com.lye.todo02.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    Long countByGuestId(String guestId);
    List<TodoEntity> findByGuestId(String guestId);
}
