package com.caitaojun.utils;

import org.mybatis.generator.api.IntrospectedTable;

public class ThreadLocalCurrentIntrospectedTable {
	private static final ThreadLocal<IntrospectedTable> currentIntrospectedTable = new ThreadLocal<IntrospectedTable>();
	
	public static IntrospectedTable getCurrentIntrospectedTable(){
		return currentIntrospectedTable.get();
	}
	
	public static void setCurrentIntrospectedTable(IntrospectedTable introspectedTable){
		currentIntrospectedTable.remove();
		currentIntrospectedTable.set(introspectedTable);
	}
	
}
