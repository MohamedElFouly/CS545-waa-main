package miu.edu.demo.service;


import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.domain.dto.PostDto;

import java.util.List;

public interface CommentService {

    void save(CommentDto c);
    List<Comment> getAll();
    Comment findById(long id);
}
