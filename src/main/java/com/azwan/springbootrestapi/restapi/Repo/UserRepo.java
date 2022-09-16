package com.azwan.springbootrestapi.restapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azwan.springbootrestapi.restapi.Models.User;


public interface UserRepo extends JpaRepository< User , Long > {
    
}
