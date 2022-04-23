package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Long countById(Integer id);

}
