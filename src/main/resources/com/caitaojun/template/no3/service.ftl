package ${servicePackage};

import java.util.List;
import ${doaminPackage}.${doaminClassName};

public interface ${doaminClassName}Service {
	
	public ${doaminClassName} save(${doaminClassName} ${doaminClassName?uncap_first});
	
	public List<${doaminClassName}> save(List<${doaminClassName}> ${doaminClassName?uncap_first}s);
	
	public void delete(${doaminClassName} ${doaminClassName?uncap_first});
	
	public void batchDelete(String[] ids);
	
	public ${doaminClassName} findOne(${doaminClassName} ${doaminClassName?uncap_first});
	
	public List<${doaminClassName}> findPageData(${doaminClassName} pojo,Integer pageNumber,Integer pageSize);

	public Integer selectCount(${doaminClassName} ${doaminClassName?uncap_first});	
}
