package com.lye.todo02.Todo;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private Long no;
    private String guestId;
    private String content;
    private boolean complete;
}
