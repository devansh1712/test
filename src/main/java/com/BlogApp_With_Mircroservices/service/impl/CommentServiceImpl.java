package com.BlogApp_With_Mircroservices.service.impl;

import com.BlogApp_With_Mircroservices.entity.Comment;
import com.BlogApp_With_Mircroservices.entity.Post;
import com.BlogApp_With_Mircroservices.exception.ResourceNotFound;
import com.BlogApp_With_Mircroservices.payload.PostDto;
import com.BlogApp_With_Mircroservices.payload.PostWithCommentDto;
import com.BlogApp_With_Mircroservices.repository.CommentRepository;
import com.BlogApp_With_Mircroservices.payload.CommentDto;
import com.BlogApp_With_Mircroservices.repository.PostRepository;
import com.BlogApp_With_Mircroservices.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    @Override
    public CommentDto createComment(CommentDto commentDto,long postId) {//This lin ewe r giving Dto & ID.
        Optional<Post> byId = postRepository.findById(postId);//line 23,24 i am getting id by post
        Post post = byId.get();

        Comment comment = mapToEntity(commentDto);//converting Dto to entity
        comment.setPost(post);//This line i am telling the comment for this post
        Comment savedComment = commentRepository.save(comment);//Saving this post
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }
    public PostWithCommentDto getAllCommentByPostId(long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Comment not found with id :" + id)
        );

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        List<Comment> comments = commentRepository.findByPostId(id);
        //lets convert all the comment object into a list of dto
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        PostWithCommentDto postWithCommentDto =  new PostWithCommentDto();
        postWithCommentDto.setCommentDto(dtos);
        postWithCommentDto.setPost(dto);
        return postWithCommentDto;
    }
   Comment mapToEntity(CommentDto dto){
       Comment comment = modelMapper.map(dto, Comment.class);
       return comment;
   }
   CommentDto mapToDto(Comment comment){
       return modelMapper.map(comment, CommentDto.class);//THE COMMENT CONTENT COPYING TO COMMENT DTO
   }
}
