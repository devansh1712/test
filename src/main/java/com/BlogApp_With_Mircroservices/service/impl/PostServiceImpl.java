//06 jan
package com.BlogApp_With_Mircroservices.service.impl;

import com.BlogApp_With_Mircroservices.entity.Comment;
import com.BlogApp_With_Mircroservices.entity.Post;
import com.BlogApp_With_Mircroservices.exception.ResourceNotFound;
import com.BlogApp_With_Mircroservices.payload.CommentDto;
import com.BlogApp_With_Mircroservices.payload.ListPostDto;
import com.BlogApp_With_Mircroservices.payload.PostDto;
import com.BlogApp_With_Mircroservices.repository.PostRepository;
import com.BlogApp_With_Mircroservices.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service()
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    private ModelMapper modelMapper;
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        //<07 feb>
        Post post = mapToEntity(postDto);
        //</07 jan>
  //      Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
       Post savedpost = postRepository.save(post);

       //<07 feb>
       PostDto dto = mapToDto(savedpost);
        //</07 jan>
 //      PostDto dto = new PostDto();
//       dto.setId(savedpost.getId());
//       dto.setTitle(savedpost.getTitle());
//       dto.setDescription(savedpost.getDescription());
//       dto.setContent(savedpost.getContent());
       return dto;
    }


    //</06 feb>

    //<07 feb>
   Post mapToEntity(PostDto postDto) {
       Post post = modelMapper.map(postDto,Post.class);
 //       Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
       return post;
    }
    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());
        return dto;


    }
    //</07 feb>
    //<08 feb>
    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
//<21 feb>

    }

    @Override
    public ListPostDto fetchAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort =sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()//feb23
                :Sort.by(sortBy).descending();//feb23
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        //  List<Post> post = postRepository.findAll();
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDtos = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        ListPostDto listPostDto = new ListPostDto(); //feb23
        listPostDto.setPostDto(postDtos); //feb23
        listPostDto.setTotalPages(all.getTotalPages());
        listPostDto.setTotalElements((int) all.getTotalElements());
        listPostDto.setFirstPage(all.isFirst());
        listPostDto.setLastPage(all.isLast());
        listPostDto.setPageNumber(all.getNumber());
        return listPostDto;

    }

//<04 March>
    public  PostDto getPosyById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Post not found with id :" + id)

        );
        return mapToDto(post);
    }

    }

