package com.BlogApp_With_Mircroservices.service;

import com.BlogApp_With_Mircroservices.payload.CommentDto;
import com.BlogApp_With_Mircroservices.payload.PostWithCommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);
     PostWithCommentDto getAllCommentByPostId(long id);
}
