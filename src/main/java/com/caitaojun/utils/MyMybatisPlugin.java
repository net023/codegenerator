package com.caitaojun.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import com.caitaojun.generatecode.RelationTableInfo2;
import com.caitaojun.generatecode.RelationTableStr;

public class MyMybatisPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
//		System.out.println("init.....:"+introspectedTable.getFullyQualifiedTable().getDomainObjectName());
//		ThreadLocalCurrentIntrospectedTable.setCurrentIntrospectedTable(introspectedTable);
		ThreadLocalCurrentIntrospectedTable.setCurrentIntrospectedTable(introspectedTable.getFullyQualifiedTable().getDomainObjectName(), introspectedTable);
		javaPropertyHandler(introspectedTable);
		super.initialized(introspectedTable);
	}


	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
//		org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();
//		field.setName("ctj");
//		field.setVisibility(JavaVisibility.PUBLIC);
//		FullyQualifiedJavaType type = new FullyQualifiedJavaType("com.net023.modain.Ctj");
//		field.setType(type );
//		topLevelClass.addImportedType(type);
//		topLevelClass.addField(field);
		
		Map<String, Object> tableInfo = MybatisGenerate.tableInfos.get(introspectedTable.getTableConfiguration().getTableName());
		List<RelationTableInfo2> relationTableInfos = (List<RelationTableInfo2>)tableInfo.get("relationTableInfos");
		String domainPackageStr = MybatisGenerate.generateInfo.getDomainPackageStr();
		if(relationTableInfos!=null){
			//判断是一对一还是什么？
			for (RelationTableInfo2 relationTableInfo : relationTableInfos) {
				if(relationTableInfo.getRelationType().equals("one2one") || relationTableInfo.getRelationType().equals("many2one")){
					//添加import导包
					topLevelClass.addImportedType(domainPackageStr+"."+relationTableInfo.getPartyClassName());
					//添加字段
					org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();
					field.setName(StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName()));
					field.setVisibility(JavaVisibility.PUBLIC);
					FullyQualifiedJavaType type = new FullyQualifiedJavaType(domainPackageStr+"."+relationTableInfo.getPartyClassName());
					field.setType(type);
					topLevelClass.addField(field);
					//添加getter方法
					Method getter = new Method();
					getter.setName("get"+relationTableInfo.getPartyClassName());
					getter.setReturnType(type);
					getter.setVisibility(JavaVisibility.PUBLIC);
					String body = "return "+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+";";
					getter.addBodyLine(body);
					topLevelClass.addMethod(getter);
					//添加setter方法
					Method setter = new Method();
					setter.setName("set"+relationTableInfo.getPartyClassName());
					setter.setReturnType(null);
					Parameter parameter = new Parameter(type, StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName()));
					setter.addParameter(parameter);
					String body2 = "this."+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+" = "+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+";";
					setter.addBodyLine(body2);
					setter.setVisibility(JavaVisibility.PUBLIC);
					topLevelClass.addMethod(setter);
				}else{
					//添加import导包
					topLevelClass.addImportedType(domainPackageStr+"."+relationTableInfo.getPartyClassName());
					topLevelClass.addImportedType("java.util.List");
					//添加字段
					org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();
					field.setName(StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+"s");
					field.setVisibility(JavaVisibility.PUBLIC);
					FullyQualifiedJavaType type = new FullyQualifiedJavaType("java.util.List<"+relationTableInfo.getPartyClassName()+">");
					field.setType(type);
					topLevelClass.addField(field);
					//添加getter方法
					Method getter = new Method();
					getter.setName("get"+relationTableInfo.getPartyClassName()+"s");
					getter.setReturnType(type);
					getter.setVisibility(JavaVisibility.PUBLIC);
					String body = "return "+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+"s;";
					getter.addBodyLine(body);
					topLevelClass.addMethod(getter);
					//添加setter方法
					Method setter = new Method();
					setter.setName("set"+relationTableInfo.getPartyClassName()+"s");
					setter.setReturnType(null);
					Parameter parameter = new Parameter(type, StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+"s");
					setter.addParameter(parameter);
					String body2 = "this."+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+"s"+" = "+StringUtil.changeFirstCharToLower(relationTableInfo.getPartyClassName())+"s;";
					setter.addBodyLine(body2);
					setter.setVisibility(JavaVisibility.PUBLIC);
					topLevelClass.addMethod(setter);

				}
			}
		}
		
//		System.out.println(topLevelClass.getType().getShortName());
//		System.out.println(introspectedTable.getFullyQualifiedTable().getIntrospectedTableName());
//		List<org.mybatis.generator.api.dom.java.Field> fields = topLevelClass.getFields();
//		for (org.mybatis.generator.api.dom.java.Field field : fields) {
//			System.out.println(field.getName()+"  "+field.getType().getFullyQualifiedName());
//		}
//		System.out.println("-----------------");
//		List<IntrospectedColumn> baseColumns = introspectedTable.getAllColumns();
//		for (IntrospectedColumn introspectedColumn : baseColumns) {
//			System.out.println(introspectedColumn.getJavaProperty()+"   "+introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName());
//		}
		
		String className = topLevelClass.getType().getShortName();
//		System.out.println("plugin className:"+className);
		List<String> javaPropertyes = new ArrayList<String>();
		List<org.mybatis.generator.api.dom.java.Field> fields = topLevelClass.getFields();
		List<String> types = Arrays.asList(
				"int","byte","short","long","float","double","boolean","char",
				"java.lang.Integer","java.lang.Byte","java.lang.Short","java.lang.Long","java.lang.Float","java.lang.Double","java.lang.Boolean","java.lang.Character",
				"java.lang.String","java.util.Date"
				);
		for (org.mybatis.generator.api.dom.java.Field field : fields) {
			String fullyQualifiedName = field.getType().getFullyQualifiedName();
			//判断属性字段不是集合类型  不是自定义引用类型
			if(types.contains(fullyQualifiedName)){
				javaPropertyes.add(field.getName());
			}
		}
		ThreadLocalAllDomainJavaProperties.setAllDomainJavaProperties(className, javaPropertyes);
		
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
	}
	
	

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		//mapper java接口生成完成调用
		//判断是否有关联关系  如果有 那么就添加一个可以根据id查询对应pojo对象的完全信息对象（包括关联对象信息）
		String relationTableInfosSizeStr = introspectedTable.getTableConfigurationProperty("relationTableInfosSize");
		Object relationTableInfos = MybatisGenerate.tableInfos.get(introspectedTable.getTableConfiguration().getTableName()).get("relationTableInfos");
		if(null!=relationTableInfos && (relationTableInfosSizeStr!=null&&!relationTableInfosSizeStr.equals("0"))){
			Method method = new Method("selectRelationDataByPrimaryKey");
			method.addJavaDocLine("//根据主键查询对象数据，关联对象数据也一起查询");
			String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
			if(domainObjectName==null){
				domainObjectName = StringUtil.changeFirstCharToUpper(StringUtil.changeColumnNameToHumpName(introspectedTable.getTableConfiguration().getTableName()));
			}
			FullyQualifiedJavaType returnType = new FullyQualifiedJavaType(domainObjectName);
			method.setReturnType(returnType);
			FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getFullyQualifiedName());
			Parameter parameter = new Parameter(type, introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty());
			method.addParameter(parameter);
			interfaze.addMethod(method);
		}
		//添加一个带条件的分页查询
		Method selectPageBySelective = new Method("selectPageBySelective");
		selectPageBySelective.addJavaDocLine("//带条件的分页查询");
		String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		if(domainObjectName==null){
			domainObjectName = StringUtil.changeFirstCharToUpper(StringUtil.changeColumnNameToHumpName(introspectedTable.getTableConfiguration().getTableName()));
		}
		FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("java.util.List<"+domainObjectName+">");
		selectPageBySelective.setReturnType(returnType);
		Parameter parameter1 = new Parameter(new FullyQualifiedJavaType(domainObjectName), "pojo","@Param(\"pojo\")");
		Parameter parameter2 = new Parameter(new FullyQualifiedJavaType("java.lang.Integer"), "index","@Param(\"limitIndex\")");
		Parameter parameter3 = new Parameter(new FullyQualifiedJavaType("java.lang.Integer"), "size","@Param(\"limitSize\")");
		Parameter parameter4 = new Parameter(new FullyQualifiedJavaType("java.lang.String"), "sort","@Param(\"sort\")");
		Parameter parameter5 = new Parameter(new FullyQualifiedJavaType("java.lang.String"), "order","@Param(\"order\")");
		selectPageBySelective.addParameter(parameter1);
		selectPageBySelective.addParameter(parameter2);
		selectPageBySelective.addParameter(parameter3);
		selectPageBySelective.addParameter(parameter4);
		selectPageBySelective.addParameter(parameter5);
		interfaze.addMethod(selectPageBySelective);
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
		
		//添加统计查询Count
		Method selectCount = new Method("selectCount");
		selectCount.addJavaDocLine("//根据条件进行统计查询");
		selectCount.setReturnType(new FullyQualifiedJavaType("java.lang.Integer"));
		Parameter pojo = new Parameter(new FullyQualifiedJavaType(domainObjectName), "pojo");
		selectCount.addParameter(pojo);
		interfaze.addMethod(selectCount);
		
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	private void javaPropertyHandler(IntrospectedTable introspectedTable){
		List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
		Map<String, Object> tableInfo = MybatisGenerate.tableInfos.get(introspectedTable.getTableConfiguration().getTableName());
		List<Map<String, String>> allFields = (List<Map<String, String>>) tableInfo.get("allFields");
		if(allFields!=null){
			for (IntrospectedColumn column : baseColumns) {
//				System.out.println(column.getJavaProperty()+" 1");
				for (Map<String, String> map : allFields) {
					if(column.getJavaProperty().equals(map.get("columnName"))){
						column.setJavaProperty(map.get("fieldName"));
						//column.setActualColumnName(map.get("fieldName"));
					}
				}
			}
		}
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
//		XmlElement element = new XmlElement("ctj");
//		Attribute attribute = new Attribute("value", "net023");
//		element.addAttribute(attribute);
//		document.getRootElement().addElement(element);
		/**
		 tc.addProperty("relation", info.getRelationType());
		tc.addProperty("partyClassName", info.getPartyClassName());
		tc.addProperty("partyTableName", info.getPartyTalbeName());
		tc.addProperty("column", info.getMyColumnName());
		tc.addProperty("joinColumn", info.getPartyColumnName());
		tc.addProperty("field", info.getMyFieldName());
		tc.addProperty("joinField", info.getPartyFieldName());
		 */
//		System.out.println("ctj...");
		//给插入添加返回主键值
		if(introspectedTable.hasPrimaryKeyColumns() && "Integer".equals(introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getShortName())){
			List<Element> elements = document.getRootElement().getElements();
			for (Element element : elements) {
				tag:
					if(element instanceof XmlElement){
						List<Attribute> attributes = ((XmlElement)element).getAttributes();
						for (Attribute attribute : attributes) {
							if("insert".equals(attribute.getValue())){
								((XmlElement) element).addAttribute(new Attribute("useGeneratedKeys", "true"));
								((XmlElement) element).addAttribute(new Attribute("keyProperty", introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty()));
								break tag;
							}else if("insertSelective".equals(attribute.getValue())){
								((XmlElement) element).addAttribute(new Attribute("useGeneratedKeys", "true"));
								((XmlElement) element).addAttribute(new Attribute("keyProperty", introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty()));
								break tag;
							}
						}
					}
			}
		}
		
		//添加统计查询count
		XmlElement  selectCount = new XmlElement("select");
		selectCount.addAttribute(new Attribute("id", "selectCount"));
		selectCount.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		selectCount.addAttribute(new Attribute("resultType", "java.lang.Integer"));
		selectCount.addElement(new TextElement("select count(*) from "+introspectedTable.getTableConfiguration().getTableName()));
		XmlElement judgeParamter = new XmlElement("if");
		judgeParamter.addAttribute(new Attribute("test", "_parameter != null"));
		List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
		XmlElement selectCountWhere = new XmlElement("where");
		judgeParamter.addElement(selectCountWhere);
		for (IntrospectedColumn introspectedColumn : baseColumns) {
			String javaProperty = introspectedColumn.getJavaProperty();//属性名
			String actualColumnName = introspectedColumn.getActualColumnName();//列名
			XmlElement judgeProperty = new XmlElement("if");
			judgeProperty.addAttribute(new Attribute("test", "_parameter."+javaProperty+"!=null"));
			judgeProperty.addElement(new TextElement("and "+actualColumnName+"=#{_parameter."+javaProperty+",jdbcType="+introspectedColumn.getJdbcTypeName()+"}"));
			selectCountWhere.addElement(judgeProperty);
		}
		selectCount.addElement(judgeParamter);
		document.getRootElement().addElement(selectCount);
		
		//添加分页查询xml
		XmlElement  selectPageBySelective = new XmlElement("select");
		selectPageBySelective.addAttribute(new Attribute("id", "selectPageBySelective"));
		selectPageBySelective.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		selectPageBySelective.addElement(new TextElement("select"));
		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", "Base_Column_List"));
		selectPageBySelective.addElement(include);
		if(introspectedTable.hasBLOBColumns()){
			selectPageBySelective.addElement(new TextElement(","));
			XmlElement include2 = new XmlElement("include");
			include2.addAttribute(new Attribute("refid", "Blob_Column_List"));
			selectPageBySelective.addElement(include2);
		}
		if(introspectedTable.getContext().getJdbcConnectionConfiguration().getDriverClass().contains("mysql")){
			//mysql
			selectPageBySelective.addElement(new TextElement("from "+introspectedTable.getTableConfiguration().getTableName()));
			XmlElement where = new XmlElement("where");
			XmlElement judgepojo = new XmlElement("if");
			judgepojo.addAttribute(new Attribute("test", "pojo!=null"));
			//获取pojo的所有属性字段和表的所有列名
//			List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
			for (IntrospectedColumn introspectedColumn : baseColumns) {
				String javaProperty = introspectedColumn.getJavaProperty();//属性名
				String actualColumnName = introspectedColumn.getActualColumnName();//列名
				XmlElement judgeProperty = new XmlElement("if");
				judgeProperty.addAttribute(new Attribute("test", "pojo."+javaProperty+"!=null"));
				judgeProperty.addElement(new TextElement("and "+actualColumnName+"=#{pojo."+javaProperty+",jdbcType="+introspectedColumn.getJdbcTypeName()+"}"));
				judgepojo.addElement(judgeProperty);
			}
			where.addElement(judgepojo);
			selectPageBySelective.addElement(where);
			XmlElement judgeOrder = new XmlElement("if");
			judgeOrder.addAttribute(new Attribute("test", "sort!=null and order!=null"));
			judgeOrder.addElement(new TextElement("order by #{sort,jdbcType=VARCHAR} #{order,jdbcType=VARCHAR}"));
			selectPageBySelective.addElement(judgeOrder);
			XmlElement judgeLimitIndex = new XmlElement("if");
			judgeLimitIndex.addAttribute(new Attribute("test", "limitIndex!=null"));
			judgeLimitIndex.addElement(new TextElement("limit #{limitIndex,jdbcType=INTEGER}"));
			selectPageBySelective.addElement(judgeLimitIndex);
			XmlElement judgeLimitSize = new XmlElement("if");
			judgeLimitSize.addAttribute(new Attribute("test", "limitSize!=null"));
			judgeLimitSize.addElement(new TextElement(",#{limitSize,jdbcType=INTEGER}"));
			selectPageBySelective.addElement(judgeLimitSize);
		}else{
			//oracle
			XmlElement bind = new XmlElement("bind");
			bind.addAttribute(new Attribute("name", "endIndex"));
			bind.addAttribute(new Attribute("value", "_parameter.limitIndex+_parameter.limitSize"));
			selectPageBySelective.addElement(bind);
			selectPageBySelective.addElement(new TextElement("from ("));
			selectPageBySelective.addElement(new TextElement("select rownum r,t.* from"));
			selectPageBySelective.addElement(new TextElement("(select * from "+introspectedTable.getTableConfiguration().getTableName()));
			
			XmlElement where = new XmlElement("where");
			XmlElement judgepojo = new XmlElement("if");
			judgepojo.addAttribute(new Attribute("test", "pojo!=null"));
			//获取pojo的所有属性字段和表的所有列名
//			List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
			for (IntrospectedColumn introspectedColumn : baseColumns) {
				String javaProperty = introspectedColumn.getJavaProperty();//属性名
				String actualColumnName = introspectedColumn.getActualColumnName();//列名
				XmlElement judgeProperty = new XmlElement("if");
				judgeProperty.addAttribute(new Attribute("test", "pojo."+javaProperty+"!=null"));
				judgeProperty.addElement(new TextElement("and "+actualColumnName+"=#{pojo."+javaProperty+",jdbcType="+introspectedColumn.getJdbcTypeName()+"}"));
				judgepojo.addElement(judgeProperty);
			}
			where.addElement(judgepojo);
			selectPageBySelective.addElement(where);
			
			XmlElement judgeOrder = new XmlElement("if");
			judgeOrder.addAttribute(new Attribute("test", "sort!=null and order!=null"));
			judgeOrder.addElement(new TextElement("order by ${sort} ${order}"));
			selectPageBySelective.addElement(judgeOrder);
			
			selectPageBySelective.addElement(new TextElement(")t"));
			selectPageBySelective.addElement(new TextElement("where rownum &lt;= #{endIndex}"));
			selectPageBySelective.addElement(new TextElement(")"));
			selectPageBySelective.addElement(new TextElement("where r &gt; #{limitIndex}"));
		}
		document.getRootElement().addElement(selectPageBySelective);
		
		try {
			String relationTableInfosSizeStr = introspectedTable.getTableConfigurationProperty("relationTableInfosSize");
			Object relationTableInfos = MybatisGenerate.tableInfos.get(introspectedTable.getTableConfiguration().getTableName()).get("relationTableInfos");
			if(relationTableInfosSizeStr==null || relationTableInfosSizeStr.equals("0") || null==relationTableInfos){
				return super.sqlMapDocumentGenerated(document, introspectedTable);
			}
			
			//2.创建<select id="selectRelationDataByPrimaryKey"
			XmlElement  selectRelationDataByPrimaryKey = new XmlElement("select");
			selectRelationDataByPrimaryKey.addAttribute(new Attribute("id", "selectRelationDataByPrimaryKey"));
			selectRelationDataByPrimaryKey.addAttribute(new Attribute("resultMap", "BaseResultMap2"));
			selectRelationDataByPrimaryKey.addAttribute(new Attribute("parameterType", introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getFullyQualifiedName()));
			StringBuffer content = new StringBuffer();
			//select t1.*,t2.* t1 left join t2 on t1.xx=t2.xx where t1.id=xx
			List<RelationTableStr> allRelationTableStr = new ArrayList<>();
			String tableName = introspectedTable.getTableConfiguration().getTableName();
			ArrayList<List> ddlInfo0 = JdbcUtil.readConst("desc "+tableName, null);
			List<String> columns0 = JdbcUtil.readFileds(ddlInfo0);
			content.append("select \n");
			for (String column0 : columns0) {
				content.append("t0."+column0+" , ");
			}
			
			//获取关联关系键
			//判断是否有多对多  如果有那么其他关联表从下标2开始   0是主表  1是关联表
			ArrayList<RelationTableInfo2> dd = ((ArrayList<RelationTableInfo2>)relationTableInfos);
			/*boolean hasMany2Many = false;
			for (RelationTableInfo2 relationTableInfo2 : dd) {
				if(relationTableInfo2.getRelationType().equals("many2many")){
					hasMany2Many = true;
				}
			}*/
			for (int i = 0; i < dd.size(); i++) {
				RelationTableInfo2 relationTableInfo = dd.get(i);
				RelationTableStr relationTableStr = new RelationTableStr();
				String partyTableName = relationTableInfo.getPartyTable();
				String inMyTablePartyForeginKeyColumn = relationTableInfo.getInMyTablePartyForeginKeyColumn();
				String partyPrimaryKeyColumn = relationTableInfo.getPartyPrimaryKeyColumn();
				ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+partyTableName, null);
				List<String> columns = JdbcUtil.readFileds(ddlInfo);
				StringBuffer selectColumn = new StringBuffer();
				for (String columnName : columns) {
					selectColumn.append("t"+(relationTableInfo.getTableIndex())+"."+columnName+" as "+"t"+(relationTableInfo.getTableIndex())+"_"+columnName+" , ");
				}
				selectColumn.substring(0, selectColumn.length()-1);
				relationTableStr.setPartyTableName(partyTableName);
				relationTableStr.setPrefix("t"+(relationTableInfo.getTableIndex())+"_");
				relationTableStr.setAllColumnStr(selectColumn.toString());
				if(relationTableInfo.getRelationType().equals("one2many")){
					relationTableStr.setLeftJoinStr(" left join "+partyTableName+" t"+(relationTableInfo.getTableIndex())+" on t0."+partyPrimaryKeyColumn+"=t"+(relationTableInfo.getTableIndex())+"."+relationTableInfo.getInPartyTableMyForeginKeyColumn()+" ");
				}else if(relationTableInfo.getRelationType().equals("many2many")){
					String middleTable = relationTableInfo.getMiddleTable();
					String inMiddleTableMyForeginKeyColumn = relationTableInfo.getInMiddleTableMyForeginKeyColumn();
					String inMiddleTablePartyForeginKeyColumn = relationTableInfo.getInMiddleTablePartyForeginKeyColumn();
//					LEFT JOIN student_teacher t1 on t1.student_id = t0.id
//					LEFT JOIN teacher t2 on t2.id = t1.teacher_id
					relationTableStr.setLeftJoinStr(" left join "+middleTable+" t"+(relationTableInfo.getTableIndex()-1)+" on t0."+relationTableInfo.getMyPrimaryKeyColumn()+"=t"+(relationTableInfo.getTableIndex()-1)+"."+inMiddleTableMyForeginKeyColumn+" ");
					relationTableStr.setLeftJoinStr(relationTableStr.getLeftJoinStr()+" \n"+" left join "+partyTableName+" t"+(relationTableInfo.getTableIndex())+" on t"+(relationTableInfo.getTableIndex())+"."+partyPrimaryKeyColumn+"=t"+(relationTableInfo.getTableIndex()-1)+"."+inMiddleTablePartyForeginKeyColumn+" ");
//					relationTableStr.setLeftJoinStr(" left join "+partyTableName+" t"+(i+2)+" on t"+(i+1)+"."+inMiddleTablePartyForeginKeyColumn+"=t"+(i+2)+"."+partyPrimaryKeyColumn+" ");
				}else{
					relationTableStr.setLeftJoinStr(" left join "+partyTableName+" t"+(relationTableInfo.getTableIndex())+" on t0."+inMyTablePartyForeginKeyColumn+"=t"+(relationTableInfo.getTableIndex())+"."+partyPrimaryKeyColumn+" ");
				}
				allRelationTableStr.add(relationTableStr);
			}
			
			if(allRelationTableStr.size()==0){
				String substring = content.substring(0, content.length()-1);
				content = new StringBuffer(substring+"\n");
			}else{
				content.append("\n");
				for (int i = 0; i < allRelationTableStr.size(); i++) {
					if(i==(allRelationTableStr.size()-1)){
						String allColumnStr = allRelationTableStr.get(i).getAllColumnStr();
						allColumnStr = allColumnStr.substring(0, allColumnStr.length()-2);
						content.append(allColumnStr+"\n");
					}else{
						content.append(allRelationTableStr.get(i).getAllColumnStr()+"\n");
					}
				}
			}
			
			
			content.append("from "+tableName+" t0 \n");
			for (RelationTableStr relationTableStr : allRelationTableStr) {
				content.append(relationTableStr.getLeftJoinStr()+"\n");
			}
			content.append("where t0.id"+"="+"#{id}");
			Element contentElement = new TextElement(content.toString());
			selectRelationDataByPrimaryKey.addElement(contentElement);
			document.getRootElement().addElement(selectRelationDataByPrimaryKey);
			
			//1.创建BaseResultMap2  添加关联关系
			XmlElement  baseResultMap2 = new XmlElement("resultMap");
			baseResultMap2.addAttribute(new Attribute("id", "BaseResultMap2"));
			baseResultMap2.addAttribute(new Attribute("type", introspectedTable.getBaseRecordType()));
			//生成主键的字段映射  id result
			XmlElement myid = new XmlElement("id");
			myid.addAttribute(new Attribute("column", introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName()));
			myid.addAttribute(new Attribute("property", introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty()));
			myid.addAttribute(new Attribute("jdbcType", introspectedTable.getPrimaryKeyColumns().get(0).getJdbcTypeName()));
			baseResultMap2.addElement(myid);
//			List<IntrospectedColumn> baseColumns = introspectedTable.getBaseColumns();
			for (IntrospectedColumn introspectedColumn : baseColumns) {
				XmlElement myresult = new XmlElement("result");
				myresult.addAttribute(new Attribute("column", introspectedColumn.getActualColumnName()));
				myresult.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
				myresult.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
				baseResultMap2.addElement(myresult);
			}
			/**
			 <resultMap id="blogResult" type="Blog">
			  <id property="id" column="blog_id" />
			  <result property="title" column="blog_title"/>
			  <association property="author"
			    resultMap="authorResult" />
			  <association property="coAuthor"
			    resultMap="authorResult"
			    columnPrefix="t1_" />
			  <association property="coAuthor"
			    resultMap="authorResult"
			    columnPrefix="t2_" />
			</resultMap>
			 */
			for (int i = 0; i < dd.size(); i++) {
				RelationTableInfo2 relationTableInfo = dd.get(i);
				if("one2one".equals(relationTableInfo.getRelationType())){
					//一对一
					XmlElement  one2one = new XmlElement("association");
					one2one.addAttribute(new Attribute("property", relationTableInfo.getPartyInMyClassFieldName()));//对方在我方中的属性名
					one2one.addAttribute(new Attribute("javaType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+relationTableInfo.getPartyClassName()));//对方的类型
					for (RelationTableStr tableStr : allRelationTableStr) {
						if(tableStr.getPartyTableName().equals(relationTableInfo.getPartyTable())){
							one2one.addAttribute(new Attribute("columnPrefix", tableStr.getPrefix()));
						}
					}
					XmlElement id = new XmlElement("id");//对方的id
					id.addAttribute(new Attribute("column", relationTableInfo.getPartyPrimaryKeyColumn()));//对方在我方的列名（外键名）
					id.addAttribute(new Attribute("property", relationTableInfo.getPartyPrimaryKeyFieldName()));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
					one2one.addElement(id);
					//对方除了主键以外的列
					//1.获取对方的所有列  
					ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+relationTableInfo.getPartyTable(), null);
					List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
					for (String columnName : partyTableColumns) {
						if(!relationTableInfo.getPartyPrimaryKeyColumn().equals(columnName)){
							XmlElement result = new XmlElement("result");
							result.addAttribute(new Attribute("column", columnName));
							result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
							one2one.addElement(result);
						}
					}
					baseResultMap2.addElement(one2one);
				}else if("one2many".equals(relationTableInfo.getRelationType())){
					XmlElement  one2many = new XmlElement("collection");
					one2many.addAttribute(new Attribute("property", relationTableInfo.getPartyInMyClassFieldName()));//对方在我方中的属性名
					one2many.addAttribute(new Attribute("ofType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+relationTableInfo.getPartyClassName()));//对方的类型
					for (RelationTableStr tableStr : allRelationTableStr) {
						if(tableStr.getPartyTableName().equals(relationTableInfo.getPartyTable())){
							one2many.addAttribute(new Attribute("columnPrefix", tableStr.getPrefix()));
						}
					}
					XmlElement id = new XmlElement("id");//对方的id
					id.addAttribute(new Attribute("column", relationTableInfo.getPartyPrimaryKeyColumn()));//对方的主键列名
					id.addAttribute(new Attribute("property", relationTableInfo.getPartyPrimaryKeyFieldName()));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
					one2many.addElement(id);
					//对方除了主键以外的列
					//1.获取对方的所有列  
					ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+relationTableInfo.getPartyTable(), null);
					List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
					for (String columnName : partyTableColumns) {
						if(!relationTableInfo.getPartyPrimaryKeyColumn().equals(columnName)){
							XmlElement result = new XmlElement("result");
							result.addAttribute(new Attribute("column", columnName));
							result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
							one2many.addElement(result);
						}
					}
					baseResultMap2.addElement(one2many);
				}else if("many2one".equals(relationTableInfo.getRelationType())){
					XmlElement  many2one = new XmlElement("association");
					many2one.addAttribute(new Attribute("property", relationTableInfo.getPartyInMyClassFieldName()));//对方在我房的属性名
					many2one.addAttribute(new Attribute("javaType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+relationTableInfo.getPartyClassName()));//对方的类型
					for (RelationTableStr tableStr : allRelationTableStr) {
						if(tableStr.getPartyTableName().equals(relationTableInfo.getPartyTable())){
							many2one.addAttribute(new Attribute("columnPrefix", tableStr.getPrefix()));
						}
					}
					XmlElement id = new XmlElement("id");//对方的id
					id.addAttribute(new Attribute("column", relationTableInfo.getPartyPrimaryKeyColumn()));//对方的主键列名
					id.addAttribute(new Attribute("property", relationTableInfo.getPartyPrimaryKeyFieldName()));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
					many2one.addElement(id);
					//对方除了主键以外的列
					//1.获取对方的所有列  
					ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+relationTableInfo.getPartyTable(), null);
					List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
					for (String columnName : partyTableColumns) {
						if(!relationTableInfo.getPartyPrimaryKeyColumn().equals(columnName)){
							XmlElement result = new XmlElement("result");
							result.addAttribute(new Attribute("column", columnName));
							result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
							many2one.addElement(result);
						}
					}
					baseResultMap2.addElement(many2one);
				}else if("many2many".equals(relationTableInfo.getRelationType())){
					XmlElement  one2many = new XmlElement("collection");
					one2many.addAttribute(new Attribute("property", relationTableInfo.getPartyInMyClassFieldName()));//对方在我方中的属性名
					one2many.addAttribute(new Attribute("ofType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+relationTableInfo.getPartyClassName()));//对方的类型
					for (RelationTableStr tableStr : allRelationTableStr) {
						if(tableStr.getPartyTableName().equals(relationTableInfo.getPartyTable())){
							one2many.addAttribute(new Attribute("columnPrefix", tableStr.getPrefix()));
						}
					}
					XmlElement id = new XmlElement("id");//对方的id
					id.addAttribute(new Attribute("column", relationTableInfo.getPartyPrimaryKeyColumn()));//对方的主键列名
					id.addAttribute(new Attribute("property", relationTableInfo.getPartyPrimaryKeyFieldName()));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
					one2many.addElement(id);
					//对方除了主键以外的列
					//1.获取对方的所有列  
					ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+relationTableInfo.getPartyTable(), null);
					List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
					for (String columnName : partyTableColumns) {
						if(!relationTableInfo.getPartyPrimaryKeyColumn().equals(columnName)){
							XmlElement result = new XmlElement("result");
							result.addAttribute(new Attribute("column", columnName));
							result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
							one2many.addElement(result);
						}
					}
					baseResultMap2.addElement(one2many);
				}
			}
			document.getRootElement().addElement(1, baseResultMap2);
			
			//-----
			/*int relationTableInfosSize = Integer.parseInt(relationTableInfosSizeStr);
			for (int i = 0; i < relationTableInfosSize; i++) {
				String relation = introspectedTable.getTableConfigurationProperty("relation_"+i);
				String partyClassName= introspectedTable.getTableConfigurationProperty("partyClassName_"+i);//对方类名
				String partyTableName = introspectedTable.getTableConfigurationProperty("partyTableName_"+i);//对方表名
				String column= introspectedTable.getTableConfigurationProperty("column_"+i);//我方列名
				String joinColumn = introspectedTable.getTableConfigurationProperty("joinColumn_"+i);//对方列名
				String field = introspectedTable.getTableConfigurationProperty("field_"+i);//我方属性名
				String joinField = introspectedTable.getTableConfigurationProperty("joinField_"+i);//对方属性名
				List<Element> elements = document.getRootElement().getElements();
				tag:
					for (Element element : elements) {
						if(element instanceof XmlElement){
							List<Attribute> attributes = ((XmlElement)element).getAttributes();
							for (Attribute attribute : attributes) {
								if("BaseResultMap".equals(attribute.getValue())){
									//判断关联关系
									if("one2one".equals(relation)){
										//一对一
										XmlElement  one2one = new XmlElement("association");
										one2one.addAttribute(new Attribute("property", field));//对方在我房的属性名
										one2one.addAttribute(new Attribute("javaType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+partyClassName));//对方的类型
										XmlElement id = new XmlElement("id");//对方的id
										id.addAttribute(new Attribute("column", column));//对方在我方的列名（外键名）
										id.addAttribute(new Attribute("property", joinField));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
										one2one.addElement(id);
										//对方除了主键以外的列
										//1.获取对方的所有列  
										ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+partyTableName, null);
										List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
										for (String columnName : partyTableColumns) {
											if(!joinColumn.equals(columnName)){
												XmlElement result = new XmlElement("result");
												result.addAttribute(new Attribute("column", columnName));
												result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
												one2one.addElement(result);
											}
										}
										((XmlElement) element).addElement(one2one);
									}else if("one2many".equals(relation)){
										//一对多
										XmlElement  one2one = new XmlElement("collection");
										one2one.addAttribute(new Attribute("property", field));//对方在我房的属性名
										one2one.addAttribute(new Attribute("javaType", MybatisGenerate.generateInfo.getDomainPackageStr()+"."+partyClassName));//对方的类型
										XmlElement id = new XmlElement("id");//对方的id
										id.addAttribute(new Attribute("column", joinColumn));//对方的主键列名
										id.addAttribute(new Attribute("property", joinField));//在获取表结构的时候能拿到，当然也可以修改  //对方的属性名
										one2one.addElement(id);
										//对方除了主键以外的列
										//1.获取对方的所有列  
										ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+partyTableName, null);
										List<String> partyTableColumns = JdbcUtil.readFileds(ddlInfo);
										for (String columnName : partyTableColumns) {
											if(!joinColumn.equals(columnName)){
												XmlElement result = new XmlElement("result");
												result.addAttribute(new Attribute("column", columnName));
												result.addAttribute(new Attribute("property", StringUtil.changeColumnNameToHumpName(columnName)));
												one2one.addElement(result);
											}
										}
										((XmlElement) element).addElement(one2one);
									}else if("many2one".equals(relation)){
										//多对一
									}else if("many2many".equals(relation)){
										//多对多
									}
									break tag;
								}
							}
						}
					}
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
//		System.out.println(introspectedTable.hasPrimaryKeyColumns());
//		System.out.println(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
		try {
			Field declaredField = sqlMap.getClass().getDeclaredField("isMergeable");//true代表对mapper的xml文件追加，false代表对mapper的xml文件覆盖
			declaredField.setAccessible(true);
			if(MybatisGenerate.iscover){
				declaredField.setBoolean(sqlMap, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.sqlMapGenerated(sqlMap, introspectedTable);
	}
	
	

}
