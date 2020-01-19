package com.hci.test.repositories;

import com.hci.test.model.OrderModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleOrderRepositories extends JpaRepository<OrderModule, Integer> {

    @Query("select om from OrderModule om where om.userId=:userId")
    List<OrderModule> findModuleOrderByUserId(@Param("userId") Integer userId);
}
