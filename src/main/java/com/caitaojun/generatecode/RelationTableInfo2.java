package com.caitaojun.generatecode;

/**
relationType    关联关系
partyTable      对方表
partyClassName  对方类名
partyPrimaryKeyColumn   对方主键列
partyPrimaryKeyFieldName    对方主键属性名
partyInMyClassFieldName     对方在我方当中的属性名
myPrimaryKeyColumn          我方主键列
myPrimaryKeyFieldName       我方主键属性名
inMiddleTable               中间表
inMiddleTableMyForeginKeyColumn 中间表我方外键列
inMiddleTablePartyForeginKeyColumn  中间表对方外键列名
 * @author Administrator
 *
 *
 *relationType  box
partyTable  box
partyClassName  text
partyPrimaryKeyColumn  box
partyPrimaryKeyFieldName text
inMyTablePartyForeginKeyColumn  box
partyInMyClassFieldName text
inPartyClassMyFieldName text
myPrimaryKeyColumn  box
myPrimaryKeyFieldName  text
inMiddleTable  box
inMiddleTableMyForeginKeyColumn  box
inMiddleTablePartyForeginKeyColumn box

 */

public class RelationTableInfo2 {
	private int tableIndex;
	private String relationType;
	private String partyTable;
	private String partyClassName;
	private String partyPrimaryKeyColumn;
	private String partyPrimaryKeyFieldName;
	private String partyInMyClassFieldName;//对方在我方中的属性名
	private String myPrimaryKeyColumn;
	private String myPrimaryKeyFieldName;
	private String middleTable;
	private String inMiddleTableMyForeginKeyColumn;
	private String inMiddleTablePartyForeginKeyColumn;
	private String inPartyClassMyFieldName;//我方在对方中的属性名
	private String inPartyTableMyForeginKeyColumn;//我在对方中的外键列
	private String inMyTablePartyForeginKeyColumn;//对方在我方中的外键列
	public int getTableIndex() {
		return tableIndex;
	}
	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		if(relationType.equals("一对一")){
			this.relationType = "one2one";
		}else if(relationType.equals("一对多")){
			this.relationType = "one2many";
		}else if(relationType.equals("多对一")){
			this.relationType = "many2one";
		}else if(relationType.equals("多对多")){
			this.relationType = "many2many";
		}
	}
	public String getPartyTable() {
		return partyTable;
	}
	public void setPartyTable(String partyTable) {
		this.partyTable = partyTable;
	}
	public String getPartyClassName() {
		return partyClassName;
	}
	public void setPartyClassName(String partyClassName) {
		this.partyClassName = partyClassName;
	}
	public String getPartyPrimaryKeyColumn() {
		return partyPrimaryKeyColumn;
	}
	public void setPartyPrimaryKeyColumn(String partyPrimaryKeyColumn) {
		this.partyPrimaryKeyColumn = partyPrimaryKeyColumn;
	}
	public String getPartyPrimaryKeyFieldName() {
		return partyPrimaryKeyFieldName;
	}
	public void setPartyPrimaryKeyFieldName(String partyPrimaryKeyFieldName) {
		this.partyPrimaryKeyFieldName = partyPrimaryKeyFieldName;
	}
	public String getPartyInMyClassFieldName() {
		return partyInMyClassFieldName;
	}
	public void setPartyInMyClassFieldName(String partyInMyClassFieldName) {
		this.partyInMyClassFieldName = partyInMyClassFieldName;
	}
	public String getMyPrimaryKeyColumn() {
		return myPrimaryKeyColumn;
	}
	public void setMyPrimaryKeyColumn(String myPrimaryKeyColumn) {
		this.myPrimaryKeyColumn = myPrimaryKeyColumn;
	}
	public String getMyPrimaryKeyFieldName() {
		return myPrimaryKeyFieldName;
	}
	public void setMyPrimaryKeyFieldName(String myPrimaryKeyFieldName) {
		this.myPrimaryKeyFieldName = myPrimaryKeyFieldName;
	}
	public String getMiddleTable() {
		return middleTable;
	}
	public void setMiddleTable(String middleTable) {
		this.middleTable = middleTable;
	}
	public String getInMiddleTableMyForeginKeyColumn() {
		return inMiddleTableMyForeginKeyColumn;
	}
	public void setInMiddleTableMyForeginKeyColumn(String inMiddleTableMyForeginKeyColumn) {
		this.inMiddleTableMyForeginKeyColumn = inMiddleTableMyForeginKeyColumn;
	}
	public String getInMiddleTablePartyForeginKeyColumn() {
		return inMiddleTablePartyForeginKeyColumn;
	}
	public void setInMiddleTablePartyForeginKeyColumn(String inMiddleTablePartyForeginKeyColumn) {
		this.inMiddleTablePartyForeginKeyColumn = inMiddleTablePartyForeginKeyColumn;
	}
	public String getInPartyClassMyFieldName() {
		return inPartyClassMyFieldName;
	}
	public void setInPartyClassMyFieldName(String inPartyClassMyFieldName) {
		this.inPartyClassMyFieldName = inPartyClassMyFieldName;
	}
	public String getInPartyTableMyForeginKeyColumn() {
		return inPartyTableMyForeginKeyColumn;
	}
	public void setInPartyTableMyForeginKeyColumn(String inPartyTableMyForeginKeyColumn) {
		this.inPartyTableMyForeginKeyColumn = inPartyTableMyForeginKeyColumn;
	}
	public String getInMyTablePartyForeginKeyColumn() {
		return inMyTablePartyForeginKeyColumn;
	}
	public void setInMyTablePartyForeginKeyColumn(String inMyTablePartyForeginKeyColumn) {
		this.inMyTablePartyForeginKeyColumn = inMyTablePartyForeginKeyColumn;
	}
}
