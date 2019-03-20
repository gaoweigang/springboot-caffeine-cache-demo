package com.gwg.demo.common.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import static com.gwg.demo.constants.GlobalConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用@EnableCaching注解启用缓存
 * 启用缓存之后，第一次会执行方法，后面均从缓存中取
 */
@Component
public class BaseCache {

	private static Map<String, List> productMap = new HashMap<>();

	static{
		List<String> productFruitsList = new ArrayList<>();
		productFruitsList.add("pear");
		productFruitsList.add("apple");
		productMap.put("fruits", productFruitsList);

		List<String> productMeatList = new ArrayList<>();
		productMeatList.add("pig");
		productMeatList.add("dog");
		productMap.put("meat", productMeatList);

	}

    //查询快件类型
    @Cacheable(cacheNames = "productUpDownCount", key = "'queryProductUpDownCount'")
    public Integer queryProductUpDownCount(String category){
    	System.out.println("queryProductUpDownCount 如果进入方法里面了 说明没走缓存");
		List<String> list = productMap.get(category);
		int count = 0;
		for(List tempList : productMap.values()){
			count += tempList.size();
		}
		return list == null? 0: list.size();
    }


	@Cacheable(cacheNames = "productList", key = "'queryProductList'")
	public List<String> queryProductList(String category){
		System.out.println("queryProductList 如果进入方法里面了 说明没走缓存");
		return productMap.get(category);
	}

	@Cacheable(cacheNames = "productSize", key = KEY_TEST)
	public Integer queryProductSize(String category){
		System.out.println("productSize 如果进入方法里面了 说明没走缓存");
		List<String> list = productMap.get(category);
		return list == null? 0: list.size();
	}


    //删除缓存
    
    //更新缓存
    
 
    
}
