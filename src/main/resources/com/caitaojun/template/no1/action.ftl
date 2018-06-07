package ${actionPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ${domainClass};
import ${servicePackage}.${domainClassName}Service;

@ParentPackage("json-default")
@Namespace("/${domainClassName?uncap_first}")
@Controller
@Scope("prototye")
public class ${domainClassName}Action extends ActionSupport implements ModelDriven<${domainClassName}>{
	private ${domainClassName} ${domainClassName?uncap_first} = new ${domainClassName}();
	
	private int page;
	private int rows;
	
	public void setPage(int page) {
		this.page = page;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	@Override
	public ${domainClassName} getModel() {
		return ${domainClassName?uncap_first};
	}
	@Autowired
	private ${domainClassName}Service ${domainClassName?uncap_first}Service;

	//增、改
	@Actions({
		@Action(value = "save", results = {@Result(name = "success", type = "json")}),
		@Action(value = "update", results = {@Result(name = "success", type = "json")})
	})
	public String save() {
		Map<String, Object> result = new HashMap<>();
		try {
			${domainClassName?uncap_first}Service.save(${domainClassName?uncap_first});
			result.put("message", "保存成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "保存成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//删
	@Action(value = "delete", results = {@Result(name = "success", type = "json")})
	public String delete() {
		Map<String, Object> result = new HashMap<>();
		try {
			${domainClassName?uncap_first}Service.delete(${domainClassName?uncap_first});
			result.put("message", "删除成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//批量删除
	@Action(value = "batchDelete", results = {@Result(name = "success", type = "json")})
	public String batchDelete() {
		Map<String, Object> result = new HashMap<>();
		try {
			${domainClassName?uncap_first}Service.batchDelete(ids.split(","));
			result.put("message", "删除成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//查
	@Action(value = "findOne", results = {@Result(name = "success", type = "json")})
	public String findOne() {
		Map<String, Object> result = new HashMap<>();
		try {
			${domainClassName} data = ${domainClassName?uncap_first}Service.findOne(${domainClassName?uncap_first});
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//查全部
	@Action(value = "findAll", results = {@Result(name = "success", type = "json")})
	public String findAll() {
		Map<String, Object> result = new HashMap<>();
		try {
			List<${domainClassName}> ${domainClassName?uncap_first}s = ${domainClassName?uncap_first}Service.findAll();
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", ${domainClassName?uncap_first}s);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//分页查
	@Action(value = "pageQuery", results = {@Result(name = "success", type = "json")})
	public String pageQuery() {
		Map<String, Object> result = new HashMap<>();
		try {
			Pageable pageable = new PageRequest(page-1, rows);
			Page<${domainClassName}> pageData = ${domainClassName?uncap_first}Service.pageQuery(pageable);
			Map<String, Object> data = new HashMap<>();
			data.put("total", pageData.getTotalElements());
			data.put("rows", pageData.getContent());
			result.put("message", "删除成功!");
			result.put("success", true);
			result.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除成功!");
			result.put("success", false);
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
}