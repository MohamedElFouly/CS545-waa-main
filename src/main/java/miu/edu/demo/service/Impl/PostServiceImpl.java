package miu.edu.demo.service.Impl;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.repo.PostRepo;
import miu.edu.demo.repo.UserRepo;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public void save(PostDto dto) {
        Post p = new Post();
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        var user = userRepo.findById(dto.getIdUser());
        p.setUser(user);
        postRepo.save(p);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id);
    }

    @Override
    public List<Post> findPostByUser(long idUser) {
        User user = userRepo.findById(idUser);
        return postRepo.findAllByUser(user);
    }

    @Override
    public List<Post> findTitle(String title) {
        return postRepo.findAllByTitle(title);
    }

    @Override
    public List<Long> findAllByUserCount(int count) {
        return postRepo.findAllByUserCount(count);
    }
}
