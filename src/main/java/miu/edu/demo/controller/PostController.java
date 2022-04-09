package miu.edu.demo.controller;


import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.FilterDto;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.domain.dto.UserDto;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public void savePost(@RequestBody PostDto p){
        postService.save(p);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getPosts(){
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable("postId") long id){
        return postService.findById(id);
    }

    @GetMapping("/filter/title/{title}")
    public List<Post> findTitle(@PathVariable("title") String title){
        return postService.findTitle(title);
    }

    /*@GetMapping()
    public List<Post> findTitle1(FilterDto obj){ // "?name=XX&title=YY"
        return postService.findTitle(obj.getName());
    }*/


    /*@GetMapping
    public List<Post> findTitle(@PathVariable("title") String title){
        return postService.findTitle(title);
    }*/

}
