package ${controllerPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${domainPackage}.${domainClassName};
import ${servicePackage}.${domainClassName}Service;

@Controller
@Scope("prototype")
@RequestMapping("/${domainClassName?uncap_first}")
public class ${domainClassName}Controller {
	
	@Autowired
	private ${domainClassName}Service ${domainClassName?uncap_first}Service;

	//增、改
	@RequestMapping({"/save","/update"})
	@ResponseBody
	public Object save(${domainClassName} ${domainClassName?uncap_first}) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${domainClassName?uncap_first}Service.save(${domainClassName?uncap_first});
			result.put("message", "保存成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "保存失败!");
			result.put("success", false);
		}
		return result;
	}
	
	//删
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(${domainClassName} ${domainClassName?uncap_first}) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${domainClassName?uncap_first}Service.delete(${domainClassName?uncap_first});
			result.put("message", "删除成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除失败!");
			result.put("success", false);
		}
		return result;
	}
	
	//批量删除
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Object batchDelete(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${domainClassName?uncap_first}Service.batchDelete(ids.split(","));
			result.put("message", "删除成功!");
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除失败!");
			result.put("success", false);
		}
		return result;
	}
	
	//查
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(${domainClassName} ${domainClassName?uncap_first}) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${domainClassName} data = ${domainClassName?uncap_first}Service.findOne(${domainClassName?uncap_first});
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取失败!");
			result.put("success", false);
		}
		return result;
	}
	
	//查全部
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll(String sort,String order) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<${domainClassName}> ${domainClassName?uncap_first}s = ${domainClassName?uncap_first}Service.findPageData(null,null,null,sort,order);
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", ${domainClassName?uncap_first}s);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取失败!");
			result.put("success", false);
		}
		return result;
	}
	
	//分页查
	@RequestMapping("/pageQuery")
	@ResponseBody
	public Object pageQuery(${domainClassName} ${domainClassName?uncap_first},int page,int rows,String sort,String order) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<${domainClassName}> pageData = ${domainClassName?uncap_first}Service.findPageData(${domainClassName?uncap_first}, page, rows, sort, order);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("total", ${domainClassName?uncap_first}Service.selectCount(${domainClassName?uncap_first}));
			data.put("rows", pageData);
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取失败!");
			result.put("success", false);
		}
		return result;
	}
}