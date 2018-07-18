package com.wangan.springcloud.ribboneurekaclient.controller;

import com.wangan.springcloud.ribboneurekaclient.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangan on 2018/7/18
 * @description
 */
 @RestController
public class UserTestController {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${serviceProvider.Name}")
	private  String serviceProviderName;

	@RequestMapping("/get/user")
	public String getUser(){
		User user = new User();
		user.setId(1);
		user.setName("wangan");

		return restTemplate.postForObject("http://" +
						serviceProviderName +
						"/user",
				user, String.class);
	}

}
