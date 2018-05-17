package com.caitaojun.generatecode;

public class RelationTableStr {
	private String partyTableName;
	private String prefix;
	private String allColumnStr;
	private String leftJoinStr;
	public String getPartyTableName() {
		return partyTableName;
	}
	public void setPartyTableName(String partyTableName) {
		this.partyTableName = partyTableName;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getAllColumnStr() {
		return allColumnStr;
	}
	public void setAllColumnStr(String allColumnStr) {
		this.allColumnStr = allColumnStr;
	}
	public String getLeftJoinStr() {
		return leftJoinStr;
	}
	public void setLeftJoinStr(String leftJoinStr) {
		this.leftJoinStr = leftJoinStr;
	}
	
}
