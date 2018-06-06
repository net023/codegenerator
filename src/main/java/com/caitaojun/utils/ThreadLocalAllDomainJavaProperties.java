package com.caitaojun.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadLocalAllDomainJavaProperties {
	private static final ThreadLocal<Map<String, List<String>>> allDomainJavaProperties = new ThreadLocal<Map<String, List<String>>>();
	
	public static Map<String, List<String>> getCurrentIntrospectedTable(){
		return allDomainJavaProperties.get();
	}
	
	public static void setAllDomainJavaProperties(String className,List<String> javaPropertyes){
		Map<String, List<String>> map = allDomainJavaProperties.get();
		if(map==null){
			map = new HashMap<String, List<String>>();
		}
		map.put(className, javaPropertyes);
		allDomainJavaProperties.set(map);
	}
	
	public static void removeAllDomainJavaProperties(){
		allDomainJavaProperties.remove();
	}
	
}
