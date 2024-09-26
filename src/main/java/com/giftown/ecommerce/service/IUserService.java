package com.giftown.ecommerce.service;

import com.giftown.ecommerce.dto.User.UserRequest;
import com.giftown.ecommerce.entity.User;

public interface IUserService {
    User registerUser(UserRequest userRequest);
}
