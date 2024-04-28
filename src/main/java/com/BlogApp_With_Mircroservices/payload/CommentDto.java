package com.BlogApp_With_Mircroservices.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class CommentDto {
    private  long id;
    private String name;
    private  String message;
}
