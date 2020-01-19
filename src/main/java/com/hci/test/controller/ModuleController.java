package com.hci.test.controller;

import com.hci.test.model.OrderModule;
import com.hci.test.model.Users;
import com.hci.test.response.ModuleResponse;
import com.hci.test.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public Map getModule(@RequestParam("userId") String userId){

        Map<String, Object> response = new HashMap<>();
        Users users = moduleService.getUserByUserId(userId);
        if(users == null){
            response.put("modules", "User not found");
            return response;
        }

        List<OrderModule> orderModules = moduleService.getOrderModuleByUserId(users.getId());
        List<ModuleResponse> moduleResponses = moduleService.getModuleResponse(orderModules);
        response.put("modules", moduleResponses);

        return response;
    }
}
