package miu.edu.demo.repo;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();
    Comment findById(long id);
}
