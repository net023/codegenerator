package com.caitaojun.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.IntrospectedTable;

public class ThreadLocalCurrentIntrospectedTable {
//	private static final ThreadLocal<IntrospectedTable> currentIntrospectedTable = new ThreadLocal<IntrospectedTable>();
	private static final ThreadLocal<Map<String, IntrospectedTable>> currentIntrospectedTable = new ThreadLocal<Map<String, IntrospectedTable>>();
	
//	public static IntrospectedTable getCurrentIntrospectedTable(){
//		return currentIntrospectedTable.get();
//	}
//	
//	public static void setCurrentIntrospectedTable(IntrospectedTable introspectedTable){
//		currentIntrospectedTable.remove();
//		currentIntrospectedTable.set(introspectedTable);
//	}
	
	public static Map<String, IntrospectedTable> getCurrentIntrospectedTable(){
		return currentIntrospectedTable.get();
	}
	
	public static void setCurrentIntrospectedTable(String className,IntrospectedTable introspectedTable){
		Map<String, IntrospectedTable> map = currentIntrospectedTable.get();
		if(map==null){
			map = new HashMap<String, IntrospectedTable>();
		}
		map.put(className, introspectedTable);
		currentIntrospectedTable.set(map);
	}
	
	public static void removeCurrentIntrospectedTable(){
		currentIntrospectedTable.remove();
	}
	
}
