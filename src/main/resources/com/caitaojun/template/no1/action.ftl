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

import ${doaminPackage}.${doaminClassName};
import ${servicePackage}.${doaminClassName}Service;

@ParentPackage("json-default")
@Namespace("/${doaminClassName?uncap_first}")
@Controller
@Scope("prototye")
public class ${doaminClassName}Action extends ActionSupport implements ModelDriven<${doaminClassName}>{
	private ${doaminClassName} ${doaminClassName?uncap_first} = new ${doaminClassName}();
	
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
	public ${doaminClassName} getModel() {
		return ${doaminClassName?uncap_first};
	}
	@Autowired
	private ${doaminClassName}Service ${doaminClassName?uncap_first}Service;

	//增、改
	@Actions({
		@Action(value = "save", results = {@Result(name = "success", type = "json")}),
		@Action(value = "update", results = {@Result(name = "success", type = "json")})
	})
	public String save() {
		Map<String, Object> result = new HashMap<>();
		try {
			${doaminClassName?uncap_first}Service.save(${doaminClassName?uncap_first});
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
			${doaminClassName?uncap_first}Service.delete(${doaminClassName?uncap_first});
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
			${doaminClassName?uncap_first}Service.batchDelete(ids.split(","));
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
			${doaminClassName} data = ${doaminClassName?uncap_first}Service.findOne(${doaminClassName?uncap_first});
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
			List<${doaminClassName}> ${doaminClassName?uncap_first}s = ${doaminClassName?uncap_first}Service.findAll();
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", ${doaminClassName?uncap_first}s);
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
			Page<${doaminClassName}> pageData = ${doaminClassName?uncap_first}Service.pageQuery(pageable);
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