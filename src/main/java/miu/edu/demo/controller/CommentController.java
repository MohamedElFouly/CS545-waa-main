package miu.edu.demo.controller;


import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.service.CommentService;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts/{postId}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void saveComment(@RequestBody CommentDto c){

        commentService.save( c);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Comment> getComments(){
        return commentService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable("commentId") long id){
        return commentService.findById(id);
    }
}
