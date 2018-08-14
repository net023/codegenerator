package com.caitaojun.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.NullProgressCallback;

import com.caitaojun.generatecode.GenerateInfo;
import com.caitaojun.generatecode.RelationTableInfo2;
import com.caitaojun.generatecode.CtjCodeGenerator;

public class MybatisGenerate {
	
	public static boolean iscover = true;
	public static Map<String,Map<String,Object>> tableInfos = null;
	public static GenerateInfo generateInfo = null;
	public static CtjCodeGenerator currentJframe = null;
	
	/*
	 	boolean iscover = checkcover.isSelected();
		boolean isexample = chckbxexample.isSelected();
		boolean generateDomain = chckbxmodel.isSelected();
		boolean generateMapper = chckbxmapper.isSelected();
		boolean generateService = chckbxservice.isSelected();
		boolean generateController = chckbxcontroller.isSelected();
		boolean generateHtml = chckbxhtml.isSelected();
		
		String domainPackageStr = txtComnetdomain.getText().trim();
		String mapperPathStr = txtComnetmapper.getText().trim();
		String daoPackageStr = txtComnetdao.getText().trim();
		String servicePackageStr = txtComnetservice.getText().trim();
		String controllerPackageStr = txtComnetwebcontroller.getText().trim();
		String htmlPathStr = txtWebapppages.getText().trim();
		
		String driverStr = null;
		String urlStr = url.getText().trim();
		String userNameStr = username.getText().trim();
		String passwordStr = password.getText().trim();
	 */
	/**
	 * 
	 * @param tableInfos
	 * @param iscover
	 * @param isexample
	 * @param generateDomain
	 * @param generateMapper
	 * @param generateService
	 * @param generateController
	 * @param generateHtml
	 * @param domainPackageStr
	 * @param mapperPathStr
	 * @param daoPackageStr
	 * @param servicePackageStr
	 * @param controllerPackageStr
	 * @param htmlPathStr
	 * @param driverStr
	 * @param urlStr
	 * @param userNameStr
	 * @param passwordStr
	 */
	public static void generate(Map<String,Map<String,Object>> tableInfos,boolean iscover,boolean isexample,boolean generateDomain,boolean generateMapper,boolean generateService
				,boolean generateController,boolean generateHtml,String domainPackageStr,String mapperPathStr,String daoPackageStr
				,String servicePackageStr,String controllerPackageStr,String htmlPathStr,String driverStr,String urlStr,
				String userNameStr,String passwordStr) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		MybatisGenerate.iscover = iscover;
		MybatisGenerate.tableInfos = tableInfos;
		Configuration configuration = new Configuration();
		Context context = new Context(ModelType.FLAT);
		//配置生成文件的编码
		context.addProperty("javaFileEncoding", "UTF-8");
		//设置Context的id
		context.setId("ctj_mybatis_generator");
		//设置mybatis或ibatis版本
		context.setTargetRuntime("MyBatis3");
		//jdbc连接配置
		JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
		jdbcConnectionConfiguration.setDriverClass(driverStr);
		jdbcConnectionConfiguration.setConnectionURL(urlStr);
		jdbcConnectionConfiguration.setUserId(userNameStr);
		jdbcConnectionConfiguration.setPassword(passwordStr);
//		jdbcConnectionConfiguration.addProperty("remarksReporting", "true");
		//添加jdbc连接配置
		context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
		//添加表信息  tableInfo {generateClassName、allFields{columnName、fieldName}、relationTableInfo}
		context.introspectTables(new NullProgressCallback(), warnings, null);
		Set<String> tableNames = tableInfos.keySet();
		for (String tableName : tableNames) {
			TableConfiguration tc = new TableConfiguration(context);
			Map<String, Object> tableInfo = tableInfos.get(tableName);
			tc.setTableName(tableName);
//			ColumnOverride columnOverride = new ColumnOverride("");
//			tc.addColumnOverride(columnOverride);
//			ColumnRenamingRule columnRenamingRule = new ColumnRenamingRule();
//			columnRenamingRule.setSearchString("");
//			tc.setColumnRenamingRule(columnRenamingRule);
			if(tableInfo.get("generateClassName")!=null){
				tc.setDomainObjectName(tableInfo.get("generateClassName")+"");
			}
			List<RelationTableInfo2> relationTableInfos = (List<RelationTableInfo2>) tableInfo.get("relationTableInfos");
			if(null!=relationTableInfos){
				tc.addProperty("relationTableInfosSize", relationTableInfos.size()+"");
				for (int i = 0; i < relationTableInfos.size(); i++) {
					tc.addProperty("relation_"+i, relationTableInfos.get(i).getRelationType());
					tc.addProperty("partyClassName_"+i, relationTableInfos.get(i).getPartyClassName());
					tc.addProperty("partyTableName_"+i, relationTableInfos.get(i).getPartyTable());
					//ps:  table_1  table_2   table_1.foreginKey=table_2.id
					if(relationTableInfos.get(i).getRelationType().equals("one2many")){
						tc.addProperty("column_"+i, relationTableInfos.get(i).getInPartyTableMyForeginKeyColumn());//对方在我方中的外键列
					}else if(relationTableInfos.get(i).getRelationType().equals("many2many")){
//						tc.addProperty("column_"+i, relationTableInfos.get(i).);//对方在我方中的外键列
					}else{
						tc.addProperty("column_"+i, relationTableInfos.get(i).getInMyTablePartyForeginKeyColumn());//对方在我方中的外键列
					}
					tc.addProperty("joinColumn_"+i, relationTableInfos.get(i).getPartyPrimaryKeyColumn());//对方表主键列
					tc.addProperty("field_"+i, relationTableInfos.get(i).getPartyInMyClassFieldName());//对方在我方class中得属性名
					tc.addProperty("joinField_"+i, relationTableInfos.get(i).getPartyPrimaryKeyFieldName());//对方class中得主键属性名
				}
			}
			if(!isexample){
				tc.setCountByExampleStatementEnabled(false);
				tc.setDeleteByExampleStatementEnabled(false);
				tc.setSelectByExampleStatementEnabled(false);
				tc.setUpdateByExampleStatementEnabled(false);
			}
			context.addTableConfiguration(tc);
		}
		//添加生成doamin配置
		if(generateDomain){
			JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
			javaModelGeneratorConfiguration.setTargetPackage(domainPackageStr);
			javaModelGeneratorConfiguration.setTargetProject("src/main/java");
			context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
		}
		//添加生成mapper配置
		if(generateMapper){
			SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
			sqlMapGeneratorConfiguration.setTargetPackage(mapperPathStr);
			sqlMapGeneratorConfiguration.setTargetProject("src/main/resources");
			context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
			
			//生成dao
			JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
			javaClientGeneratorConfiguration.setTargetProject("src/main/java");
			javaClientGeneratorConfiguration.setTargetPackage(daoPackageStr);
			javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
			context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
		}
		//去掉注释   true祛掉  false不祛
		CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
		commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
		commentGeneratorConfiguration.addProperty("suppressDate", "true");
		context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
		//添加自定义插件
		PluginConfiguration pluginConfiguration = new PluginConfiguration();
		pluginConfiguration.setConfigurationType("com.caitaojun.utils.MyMybatisPlugin");
		context.addPluginConfiguration(pluginConfiguration);
		//添加 上下文配置
		configuration.addContext(context);
		ShellCallback shellCallback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
		myBatisGenerator.generate(null);
		
	}
	
}
