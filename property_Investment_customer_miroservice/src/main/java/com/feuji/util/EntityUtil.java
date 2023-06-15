package com.feuji.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EntityUtil {
	
	@Value("${environment}")	
	private  String environment;
	
	@Value("${dev-url}")
	private String devUrl;
	
	@Value("${prod-url}")
	private String prodUrl;
	
	public   String getUrl()
	
	{
		
		System.out.println(environment);
	
		if( "dev".equals(environment))
		{
			System.out.println(devUrl);
			return devUrl;
		}
		else
		{
			return prodUrl;
		}
		
	}
}
