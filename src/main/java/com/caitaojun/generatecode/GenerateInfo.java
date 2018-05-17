package com.caitaojun.generatecode;

public class GenerateInfo {
	private boolean iscover;
	private boolean isexample;
	private boolean generateDomain;
	private boolean generateMapper;
	private boolean generateService;
	private boolean generateController;
	private boolean generateHtml;
	
	private String domainPackageStr;
	private String mapperPathStr;
	private String daoPackageStr;
	private String servicePackageStr;
	private String controllerPackageStr;
	private String htmlPathStr;
	
	private String driverStr; 
	private String urlStr; 
	private String userNameStr;
	private String passwordStr;
	
	public GenerateInfo(boolean iscover, boolean isexample, boolean generateDomain, boolean generateMapper,
			boolean generateService, boolean generateController, boolean generateHtml, String domainPackageStr,
			String mapperPathStr, String daoPackageStr, String servicePackageStr, String controllerPackageStr,
			String htmlPathStr, String driverStr, String urlStr, String userNameStr, String passwordStr) {
		super();
		this.iscover = iscover;
		this.isexample = isexample;
		this.generateDomain = generateDomain;
		this.generateMapper = generateMapper;
		this.generateService = generateService;
		this.generateController = generateController;
		this.generateHtml = generateHtml;
		this.domainPackageStr = domainPackageStr;
		this.mapperPathStr = mapperPathStr;
		this.daoPackageStr = daoPackageStr;
		this.servicePackageStr = servicePackageStr;
		this.controllerPackageStr = controllerPackageStr;
		this.htmlPathStr = htmlPathStr;
		this.driverStr = driverStr;
		this.urlStr = urlStr;
		this.userNameStr = userNameStr;
		this.passwordStr = passwordStr;
	}
	public boolean isIscover() {
		return iscover;
	}
	public void setIscover(boolean iscover) {
		this.iscover = iscover;
	}
	public boolean isIsexample() {
		return isexample;
	}
	public void setIsexample(boolean isexample) {
		this.isexample = isexample;
	}
	public boolean isGenerateDomain() {
		return generateDomain;
	}
	public void setGenerateDomain(boolean generateDomain) {
		this.generateDomain = generateDomain;
	}
	public boolean isGenerateMapper() {
		return generateMapper;
	}
	public void setGenerateMapper(boolean generateMapper) {
		this.generateMapper = generateMapper;
	}
	public boolean isGenerateService() {
		return generateService;
	}
	public void setGenerateService(boolean generateService) {
		this.generateService = generateService;
	}
	public boolean isGenerateController() {
		return generateController;
	}
	public void setGenerateController(boolean generateController) {
		this.generateController = generateController;
	}
	public boolean isGenerateHtml() {
		return generateHtml;
	}
	public void setGenerateHtml(boolean generateHtml) {
		this.generateHtml = generateHtml;
	}
	public String getDomainPackageStr() {
		return domainPackageStr;
	}
	public void setDomainPackageStr(String domainPackageStr) {
		this.domainPackageStr = domainPackageStr;
	}
	public String getMapperPathStr() {
		return mapperPathStr;
	}
	public void setMapperPathStr(String mapperPathStr) {
		this.mapperPathStr = mapperPathStr;
	}
	public String getDaoPackageStr() {
		return daoPackageStr;
	}
	public void setDaoPackageStr(String daoPackageStr) {
		this.daoPackageStr = daoPackageStr;
	}
	public String getServicePackageStr() {
		return servicePackageStr;
	}
	public void setServicePackageStr(String servicePackageStr) {
		this.servicePackageStr = servicePackageStr;
	}
	public String getControllerPackageStr() {
		return controllerPackageStr;
	}
	public void setControllerPackageStr(String controllerPackageStr) {
		this.controllerPackageStr = controllerPackageStr;
	}
	public String getHtmlPathStr() {
		return htmlPathStr;
	}
	public void setHtmlPathStr(String htmlPathStr) {
		this.htmlPathStr = htmlPathStr;
	}
	public String getDriverStr() {
		return driverStr;
	}
	public void setDriverStr(String driverStr) {
		this.driverStr = driverStr;
	}
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public String getUserNameStr() {
		return userNameStr;
	}
	public void setUserNameStr(String userNameStr) {
		this.userNameStr = userNameStr;
	}
	public String getPasswordStr() {
		return passwordStr;
	}
	public void setPasswordStr(String passwordStr) {
		this.passwordStr = passwordStr;
	}
	
}
