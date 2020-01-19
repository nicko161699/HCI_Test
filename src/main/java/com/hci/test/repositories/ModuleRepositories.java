package com.hci.test.repositories;

import com.hci.test.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleRepositories extends JpaRepository<Module, Integer> {

    @Query("select m.moduleName from Module m where m.id=:moduleId")
    String findModuleNameById(@Param("moduleId") Integer moduleId);
}
