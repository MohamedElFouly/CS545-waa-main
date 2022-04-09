package miu.edu.demo.service.Impl;


import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.repo.CommentRepo;
import miu.edu.demo.repo.PostRepo;
import miu.edu.demo.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PostRepo postRepo;

    @Override
    public void save(CommentDto c) {

        Post p = postRepo.findById(c.getIdPost());
        Comment comment = new Comment(c.getName());
        comment.setPost(p);
        //comments.add(comment);
        //p.setComments(comments);
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id);
    }
}
