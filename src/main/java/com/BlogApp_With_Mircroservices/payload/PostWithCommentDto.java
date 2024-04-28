package com.BlogApp_With_Mircroservices.payload;

import com.BlogApp_With_Mircroservices.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostWithCommentDto {
    private PostDto post;
  private List<CommentDto> commentDto = new ArrayList<>();

}
