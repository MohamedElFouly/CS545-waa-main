package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    void save(PostDto p);
    List<Post> getAll();
    Post findById(long id);
    List<Post> findPostByUser(long idUser);
    List<Post> findTitle(String title);
    List<Long> findAllByUserCount(int count);
}
