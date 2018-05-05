package com.skyjilygao.test;

import com.skyjilygao.test.api.TUserSevice;
import com.skyjilygao.test.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatasourceApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TUserSevice tUserSevice;

	@Test
	public void contextLoads() {
		System.out.print(tUserSevice.getAllList().toString());
		System.out.print(userService.getUserList().toString());
	}

}
