package com.mycompany.mywebapp.jdbc;

import com.mycompany.mywebapp.entity.Employee;

import java.util.List;

public interface DAO<Entity, ID> {
    List <Entity> findAll();
    Entity findById(ID id);
    void save(Entity model);
    void update(ID id, Entity model);
    void delete(ID id);
}
