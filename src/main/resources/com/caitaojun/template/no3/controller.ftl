package ${controllerPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${doaminPackage}.${doaminClassName};
import ${servicePackage}.${doaminClassName}Service;

@Controller
@Scope("prototye")
@RequestMapping("/${doaminClassName?uncap_first}")
public class ${doaminClassName}Controller {
	
	@Autowired
	private ${doaminClassName}Service ${doaminClassName?uncap_first}Service;

	//增、改
	@RequestMapping({"/save","/update"})
	@ResponseBody
	public Object save(${doaminClassName} ${doaminClassName?uncap_first}) {
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
		return result;
	}
	
	//删
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(${doaminClassName} ${doaminClassName?uncap_first}) {
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
		return result;
	}
	
	//批量删除
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Object delete(String ids) {
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
		return result;
	}
	
	//查
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(${doaminClassName} ${doaminClassName?uncap_first}) {
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
		return result;
	}
	
	//查全部
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll() {
		Map<String, Object> result = new HashMap<>();
		try {
			List<${doaminClassName}> ${doaminClassName?uncap_first}s = ${doaminClassName?uncap_first}Service.findPageData(null,null,null);
			result.put("message", "获取成功!");
			result.put("success", true);
			result.put("data", ${doaminClassName?uncap_first}s);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "获取成功!");
			result.put("success", false);
		}
		return result;
	}
	
	//分页查
	@RequestMapping("/pageQuery")
	@ResponseBody
	public Object pageQuery(${doaminClassName} ${doaminClassName?uncap_first},int page,int rows) {
		Map<String, Object> result = new HashMap<>();
		try {
			List<${doaminClassName}> pageData = ${doaminClassName?uncap_first}Service.findPageData(${doaminClassName?uncap_first}, page, rows);
			Map<String, Object> data = new HashMap<>();
			data.put("total", ${doaminClassName?uncap_first}Service.selectCount(${doaminClassName?uncap_first}));
			data.put("rows", pageData);
			result.put("message", "删除成功!");
			result.put("success", true);
			result.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "删除成功!");
			result.put("success", false);
		}
		return result;
	}
}