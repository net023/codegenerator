package ${servicePackage};

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import ${doaminPackage}.${doaminClassName};

public interface ${doaminClassName}Service {
	
	public ${doaminClassName} save(${doaminClassName} ${doaminClassName?uncap_first});
	
	public List<${doaminClassName}> save(List<${doaminClassName}> ${doaminClassName?uncap_first}s);
	
	public void delete(${doaminClassName} ${doaminClassName?uncap_first});
	
	public void batchDelete(String[] ids);
	
	public ${doaminClassName} findOne(${doaminClassName} ${doaminClassName?uncap_first});
	
	public List<${doaminClassName}> findAll();
	
	public Page<${doaminClassName}> pageQuery(Pageable pageable);
	
	public Page<${doaminClassName}> pageQuery(Specification<${doaminClassName}> specification,Pageable pageable);
	
}
