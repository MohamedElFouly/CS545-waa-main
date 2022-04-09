package miu.edu.demo.service.Impl;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.domain.dto.UserDto;
import miu.edu.demo.helper.ListMapper;
import miu.edu.demo.repo.PostRepo;
import miu.edu.demo.repo.UserRepo;
import miu.edu.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;


    @Autowired
    ListMapper<User,UserDto> listMapperUserToDto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperUserToDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public UserDto findByIdDto(long id) {
        return modelMapper.map( userRepo.findById(id) , UserDto.class );
    }

    @Override
    public List<User> findAllByIdIn(List<Long> user_ids) {
        return userRepo.findAllByIdIn(user_ids);
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(UserDto p) {
        userRepo.save(modelMapper.map(p, User.class));
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findUsersWithGivenNumberOfPosts(int count) {
        return userRepo.findUsersWithGivenNumberOfPosts(count);
    }


    /*@Override
    public List<User> findHaveReviewMoreThan(int n) {
        return userRepo.findHaveReviewMoreThan(n);
    }


    @Override
    public List<User> findByPriceGreaterThan(float price) {

        return userRepo.findByPriceGreaterThan(price);


    }*/


}
