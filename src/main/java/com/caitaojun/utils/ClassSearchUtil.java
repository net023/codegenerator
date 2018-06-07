package com.caitaojun.utils;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassSearchUtil {
	
	public static void findClassPlus(String basePath,List<Class> classList) throws Exception{
		String basePath2 = basePath.replace(".", "/");
		Enumeration<URL> resources = ClassSearchUtil.class.getClassLoader().getResources(basePath2);
		while(resources.hasMoreElements()){
			URL element = resources.nextElement();
			if(element.getProtocol().equals("jar")){
				String path = element.getPath();
				//file:/D:/ProgramFiles/workspace/ssh/ccwebmvc/WebContent/WEB-INF/lib/jfinal-3.0.jar!/com/jfinal
				path = path.substring("file:/".length());
				path = path.substring(0,path.length()-basePath2.length()-2);
				JarFile entry = new JarFile(path);
				Enumeration<JarEntry> entries = entry.entries();
				while(entries.hasMoreElements()){
					JarEntry jarEntry = entries.nextElement();
					if(!jarEntry.isDirectory()){
						if(jarEntry.getName().endsWith("class")){
							String className = jarEntry.getName();
							className = className.substring(0, className.length()-6);
							className = className.replace("/", ".");
							if(className.startsWith(basePath)){
								Class<?> clazz = Class.forName(className, false, ClassSearchUtil.class.getClassLoader());
								classList.add(clazz);
								
							}
						}
					}
				}
			}else{
				File rootPath = new File(element.getPath());
				deepSearchClass(rootPath,classList,basePath);
			}
		}
	}
	
	
	private static void deepSearchClass(File path,List<Class> classArray,String basePath) throws Exception{
		//0.判断path是否存在
		if(path.exists()){
			//1.判断path是否是目录
			if(path.isDirectory()){
				//2.获取当前目录的文件和子目录
				File[] listFiles = path.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						if(file.isDirectory()){
							return true;
						}
						if(file.getName().endsWith("class")){
							return true;
						}
						return false;
					}
				});
				for (File file : listFiles) {
					deepSearchClass(file, classArray, basePath);
				}
			}else{
				//D:\ProgramFiles\workspace\ssh\ccwebmvc\build\classes\com\caitaojun\User.class
//				int idx = (System.getProperty("user.dir")+"/target/classes/").length();
//				String classFileString = path.getCanonicalPath().substring(idx);
				String classFileString = path.getCanonicalPath().split("classes")[1];
				classFileString = classFileString.substring(1, classFileString.length()-6);
				classFileString = classFileString.replace(File.separator, ".");
				if(classFileString.startsWith(basePath)){
					Class<?> clazz = Class.forName(classFileString, false, ClassSearchUtil.class.getClassLoader());
					classArray.add(clazz);
				}
			}
		}
	}
}
