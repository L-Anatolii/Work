package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.user.User;
import com.mycompany.mywebapp.user.UserNotFoundException;
import com.mycompany.mywebapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private MailSender mailSender;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public void save(User user){
        repo.save(user);
        mailSender.send(user.getEmail(), user.getFirstName(), "Добавлен пользователь");
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID"+ id);
    }
    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID"+ id);
        }
        repo.deleteById(id);
    }
}