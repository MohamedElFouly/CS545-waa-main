package miu.edu.demo.controller;


import miu.edu.demo.aspect.annotation.ExecutionTime;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.UserDto;
import miu.edu.demo.service.PostService;
import miu.edu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}/dto")
    public UserDto getUserDto(@PathVariable("id") long id){
        return userService.findByIdDto(id);
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPosts(@PathVariable("id") long idUser){
        return postService.findPostByUser(idUser);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser( @RequestBody UserDto p ){
        userService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.delete(id);
    }

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping("/count/{count}")
    public List<User> getUsers(@PathVariable int count){
        List<Long> user_ids = postService.findAllByUserCount(count);
        return userService.findAllByIdIn(user_ids);
    }*/

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/count/{count}")
    public List<User> getUsers(@PathVariable int count){
        return userService.findUsersWithGivenNumberOfPosts(count);
    }



   /* @GetMapping("/filter/review/{val}")
    public List<User> findProductsReviewMoreThan(@PathVariable("val") int val){
        return userService.findHaveReviewMoreThan(val);
    }

    @GetMapping("/filter/price/{val}")
    public List<User> findByPrice(@PathVariable("val") float val){
        return productService.findByPriceGreaterThan(val);
    }*/




}
