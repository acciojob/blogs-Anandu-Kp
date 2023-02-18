package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository;

    public User createUser(String username, String password){

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        List<Blog> blogList=new ArrayList<>();
        user.setBlogList(blogList);
        userRepository3.save(user);
        return user;

    }

    public void deleteUser(int userId){

        User user=userRepository3.findById(userId).get();
        List<Blog> blogList=user.getBlogList();
        List<Image> imageList;
        for(Blog blog : blogList)
        {
            imageList=blog.getImageList();
            for(Image image : imageList)
            {
                imageRepository.deleteById(image.getId());
            }
            blogRepository.deleteById(blog.getId());
        }
        userRepository3.deleteById(userId);

    }

    public User updateUser(Integer id, String password){

      User user= userRepository3.findById(id).get();
      user.setPassword(password);
      userRepository3.save(user);
      return user;
    }
}
