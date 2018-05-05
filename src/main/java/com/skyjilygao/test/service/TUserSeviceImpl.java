package com.skyjilygao.test.service;

import com.skyjilygao.test.api.TUserSevice;
import com.skyjilygao.test.dao.second.TUserMapper;
import com.skyjilygao.test.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SKYJILYGAO on 2018/5/5.
 */
@Service
public class TUserSeviceImpl implements TUserSevice {
    @Autowired
    private TUserMapper tUserMapper;
    public List<TUser> getAllList() {
        return tUserMapper.getAllList();
    }
}
