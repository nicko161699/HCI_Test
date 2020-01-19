package com.hci.test;

import com.hci.test.model.Users;
import com.hci.test.service.ModuleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.fail;

public class ModuleServiceTest {

    @Autowired
    private ModuleService moduleService;

    @Test(expected = NullPointerException.class)
    public void getUserByUserIdTest(){

        try {
            Users u = moduleService.getUserByUserId("userA");
            fail(u.getUserId());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
