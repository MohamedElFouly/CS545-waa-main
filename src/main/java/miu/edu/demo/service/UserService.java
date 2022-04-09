package miu.edu.demo.service;


import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findByIdDto(long id);

    List<User> findAllByIdIn(List<Long> user_ids);

    User findById(long id);

    void save(UserDto user);

    void delete(long id);

    List<User> findUsersWithGivenNumberOfPosts(int count);

    //List<User> findHaveReviewMoreThan(int n);

    //List<User> findByPriceGreaterThan(float price);
}
