package com.hci.test.repositories;

import com.hci.test.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepositories extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.userId=:userId")
    Users findUsersByUserId(@Param("userId") String userId);

}
