package com.lye.todo02.Todo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "todo")
@SequenceGenerator(name = "abc", sequenceName = "seq_todo", allocationSize = 1)
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abc")
    private Long id;

    private Long no;
    private String guestId;
    private String content;
    private boolean complete;
}
