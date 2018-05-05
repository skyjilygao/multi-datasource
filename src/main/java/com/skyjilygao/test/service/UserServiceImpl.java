package com.skyjilygao.test.service;

import com.skyjilygao.test.api.UserService;
import com.skyjilygao.test.dao.master.UserMapper;
import com.skyjilygao.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SKYJILYGAO on 2018/5/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
