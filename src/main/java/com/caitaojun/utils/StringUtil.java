package com.caitaojun.utils;

import java.util.regex.Pattern;

import org.mybatis.generator.internal.util.StringUtility;

public class StringUtil {
	public static String changeFirstCharToUpper(String src) {
		char c = src.charAt(0);
		String regex = "[^a-z]";
		boolean notLower = Pattern.matches(regex, c + "");
		if (notLower) {
			return src;
		}
		return src.replaceFirst(src.charAt(0) + "", (char) (src.charAt(0) - 32) + "");
	}
	
	public static String changeFirstCharToLower(String src) {
		char c = src.charAt(0);
		String regex = "[^A-Z]";
		boolean notUpper = Pattern.matches(regex, c + "");
		if (notUpper) {
			return src;
		}
		return src.replaceFirst(src.charAt(0) + "", (char) (src.charAt(0) + 32) + "");
	}
	
	//转变表的列名为驼峰类型   user_id //第一个字符小写
	public static String changeColumnNameToHumpName(String src){
		String lowerStr = changeFirstCharToLower(src);
		if(StringUtility.stringContainsSQLWildcard(lowerStr)){
			String[] splits = lowerStr.split("_");
			StringBuffer sbf = new StringBuffer();
			for (int i = 0; i < splits.length; i++) {
				if(i==0){
					sbf.append(splits[0]);
				}else{
					sbf.append(changeFirstCharToUpper(splits[i]));
				}
			}
			return sbf.toString();
		}
		return lowerStr;
	}
}
