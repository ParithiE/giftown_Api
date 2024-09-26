package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.User.UserRequest;
import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.dto.order.OrderResponseModel;
import com.giftown.ecommerce.entity.User;
import com.giftown.ecommerce.service.IUserService;
import com.giftown.ecommerce.service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class UserMapper {
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private IUserService userService;

    public User registerUser(UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }
}
