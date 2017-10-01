package com.aalsher.admindashboard.repositories;

import java.util.List;

import com.aalsher.admindashboard.models.*;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    List<Role> findAll();
    
    Role findByName(String name);
}
