package ${servicePackage};

import java.util.List;
import ${domainPackage}.${domainClassName};

public interface ${domainClassName}Service {
	
	public ${domainClassName} save(${domainClassName} ${domainClassName?uncap_first});
	
	public List<${domainClassName}> save(List<${domainClassName}> ${domainClassName?uncap_first}s);
	
	public void delete(${domainClassName} ${domainClassName?uncap_first});
	
	public void batchDelete(String[] ids);
	
	public ${domainClassName} findOne(${domainClassName} ${domainClassName?uncap_first});
	
	public List<${domainClassName}> findPageData(${domainClassName} pojo,Integer pageNumber,Integer pageSize,String sort,String order);

	public Integer selectCount(${domainClassName} ${domainClassName?uncap_first});	
}
