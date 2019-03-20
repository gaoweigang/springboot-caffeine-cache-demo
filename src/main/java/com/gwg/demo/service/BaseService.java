package com.gwg.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwg.demo.common.cache.BaseCache;

@RestController
@Component
public class BaseService {
	

	@Autowired
	public BaseCache baseCache;
	
	@RequestMapping("/hello")
	public void hello(){
		System.out.println("hello ....");
	}
	
	@RequestMapping("/cache")
	public void queryProductSize(){
		System.out.println("test cache start....");
		System.out.println(baseCache.queryProductSize("fruits"));
		
	}

	@RequestMapping("/cache2")
	public void queryProductUpDownCount(){
		System.out.println("test cache start....");
		System.out.println(baseCache.queryProductUpDownCount("fruits"));

	}

}
