package com.veyselozturk.productuserreviewapp.repository;


import com.veyselozturk.productuserreviewapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
