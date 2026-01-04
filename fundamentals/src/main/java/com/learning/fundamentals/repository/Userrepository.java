package com.learning.fundamentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.fundamentals.model.User;


//We using JpaRepository to easily communicate to the database by using the already in build methods provided by JpaRepositoy.
@Repository
public interface Userrepository extends JpaRepository<User,Long> {

}
