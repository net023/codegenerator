package com.caitaojun.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/**
 * 
 * @author caitaojun
 *
 */
public class JarFileResUtil {
	public static void copyJarFileResToDirectory(String targetDirectory) throws IOException{
		URL resource = JarFileResUtil.class.getResource("/com/caitaojun/res/haha.gif");
		String path = resource.getPath().substring("file:/".length());
		path = path.split("!")[0];
		JarFile ff = new JarFile(path);
		Enumeration<JarEntry> entries = ff.entries();
		while (entries.hasMoreElements()) {
			JarEntry jarEntry = (JarEntry) entries.nextElement();
			//目录 例如  com/caitaojun/res/
			//文件 例如 com/caitaojun/generatecode/CtjCodeGenerator.class
			if (!jarEntry.isDirectory() && jarEntry.getName().contains("com/caitaojun/js")) {
				InputStream inputStream = ff.getInputStream(jarEntry);
				String jarEntryName = jarEntry.getName();
				jarEntryName = jarEntryName.substring("com/caitaojun/js/".length());
				List<String> resName = Arrays.asList(jarEntryName.split("/"));
				StringBuffer pathStr = new StringBuffer(targetDirectory);
				for (String pathSplit : resName) {
					pathStr.append(File.separator+pathSplit);
				}
				File destination = new File(pathStr.toString());
				copyInputStreamToFile(inputStream, destination);
				inputStream.close();
			}else if(jarEntry.isDirectory() && jarEntry.getName().contains("com/caitaojun/js")){
				String jarEntryName = jarEntry.getName();
				jarEntryName = jarEntryName.substring("com/caitaojun/js/".length());
				List<String> resName = Arrays.asList(jarEntryName.split("/"));
				StringBuffer pathStr = new StringBuffer(targetDirectory);
				for (String pathSplit : resName) {
					pathStr.append(File.separator+pathSplit);
				}
				File directory = new File(pathStr.toString());
				if(!directory.exists()){
					directory.mkdirs();
				}
			}
		}
		ff.close();
	}
	
	private static void copyInputStreamToFile(InputStream inputStream,File destination) throws IOException{
		byte[] buff = new byte[1024];
		int readLength = 0;
		FileOutputStream fos = new FileOutputStream(destination);
		while((readLength = inputStream.read(buff))!=-1){
			fos.write(buff, 0, readLength);
		}
		fos.flush();
		fos.close();
	}
	
}
