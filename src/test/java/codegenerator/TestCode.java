package codegenerator;

import java.io.File;

public class TestCode {
	public static void main(String[] args) {
		String projectname = System.getProperty("user.dir");
		System.out.println(projectname);
		String pn = projectname.substring(projectname.lastIndexOf(File.separator)+1,projectname.length());
		System.out.println(pn);
	}
}
