package com.aalsher.admindashboard.repositories;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    List<Role> findAll();
    
    List<Role> findByName(String name);
}
