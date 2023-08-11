package com.java.retrospective.dao;

import com.java.retrospective.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Integer> {

//    @Query(value = "select * from Users where id=?",nativeQuery = true)
//    UserEntity findUserByUserId(Integer userId);

}
