package com.BlogApp_With_Mircroservices.controller;

import com.BlogApp_With_Mircroservices.payload.CommentDto;
import com.BlogApp_With_Mircroservices.payload.PostWithCommentDto;
import com.BlogApp_With_Mircroservices.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This controller take comment Dto and post ID.
@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class commentController {
    private CommentService commentService;

    //http://localhost:8080/api/comments/1
    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,//JSon content goto CommentDto
            @PathVariable long postId){
        CommentDto dto = commentService.createComment(commentDto, postId);//Give data to service layer
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
     public ResponseEntity<PostWithCommentDto> getAllCommentsByPostId(@PathVariable Long postId){
        PostWithCommentDto allCommentByPostId = commentService.getAllCommentByPostId(postId);
        return  new ResponseEntity<>(allCommentByPostId,HttpStatus.OK);
     }
}
