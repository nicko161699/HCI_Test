package com.hci.test.service;

import com.hci.test.model.OrderModule;
import com.hci.test.model.Users;
import com.hci.test.repositories.ModuleOrderRepositories;
import com.hci.test.repositories.ModuleRepositories;
import com.hci.test.repositories.UsersRepositories;
import com.hci.test.response.ModuleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private UsersRepositories usersRepositories;

    @Autowired
    private ModuleOrderRepositories moduleOrderRepositories;

    @Autowired
    private ModuleRepositories moduleRepositories;

    public Users getUserByUserId(String userId) {
        return usersRepositories.findUsersByUserId(userId);
    }

    public List<OrderModule> getOrderModuleByUserId(Integer userId) {
        return moduleOrderRepositories.findModuleOrderByUserId(userId);
    }

    public List<ModuleResponse> getModuleResponse(List<OrderModule> orderModules) {
        List<ModuleResponse> result = new ArrayList<>();
        orderModules.stream().forEach(data -> buildModuleResponse(result, data));
        return result;
    }

    private void buildModuleResponse(List<ModuleResponse> result, OrderModule orderModule) {
        ModuleResponse moduleResponse = new ModuleResponse();
        String moduleName = moduleRepositories.findModuleNameById(orderModule.getModuleId());
        moduleResponse.setModuleName(moduleName);
        moduleResponse.setModuleOrder(orderModule.getModuleOrder());
        result.add(moduleResponse);
    }
}
