package com.test.project.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TestReadConfiguration {

	@Autowired
	private AppConfig appcon;
	
	public String getConfig()
	{
		System.out.println(appcon.getParam1());
		System.out.println(appcon.getParam2());
		System.out.println(appcon.getList());
		
		return appcon.getParam1();
		
	}
	
}
