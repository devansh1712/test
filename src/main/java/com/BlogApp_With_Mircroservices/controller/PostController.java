package com.BlogApp_With_Mircroservices.controller;

import com.BlogApp_With_Mircroservices.payload.ListPostDto;
import com.BlogApp_With_Mircroservices.payload.PostDto;
import com.BlogApp_With_Mircroservices.service.PostService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@CrossOrigin("http://localhost:4200")
public class PostController {
//<06 jan>
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    //http://localhost:8080/api/posts
    @PostMapping

    //public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        //<09 feb>
    public ResponseEntity<?> createPost(@Valid  @RequestBody PostDto postDto, BindingResult bindingResult) {
       // if (postDto.getTitle().length() < 3) {
        if (bindingResult.hasErrors()){
            //return new ResponseEntity<>("Title should be at least 3 characters", HttpStatus.INTERNAL_SERVER_ERROR);

         return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        if (postDto.getDescription().length() <= 5) {
            return new ResponseEntity<>("Description should be at least 5 characters", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//</09 feb>
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //</06 jan>

    //<08 jan>
    //http://localhost:8080/api/posts/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted!!", HttpStatus.OK);
        //<09feb>
    }
        //<21feb>
//    @GetMapping
//        public ResponseEntity<List<PostDto>> fetchAllPost () {
//        List<PostDto> postDtos = postService.fetchAllPost();
//        return new ResponseEntity<>(postDtos,HttpStatus.OK);
//    }
    //</21fe>
    //<22 feb>
    //PAGINATION AND SORTING
    //http://localhost:8080/api/posts?pageNo=1&pageSize=5&sortBy=description&sortDir=desc
    @GetMapping
    public ResponseEntity<ListPostDto> fetchAllPost(
            @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name ="pageSize", defaultValue = "5",required = false)int pageSize,
            @RequestParam(name ="sortBy", defaultValue = "id",required = false)String sortBy,
            @RequestParam(name ="sortDir", defaultValue = "asc",required = false)String sortDir


    ){
        ListPostDto listPostDto = postService.fetchAllPost(pageNo,pageSize,sortBy,sortDir);
        return  new ResponseEntity<>(listPostDto,HttpStatus.OK);
    }

    //<04 march>
    //http://localhost:8080/api/
    // posts
    @GetMapping("/{id}")
    public  ResponseEntity<PostDto> getPostById(@PathVariable long id ){
        PostDto dto = postService.getPosyById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    }


