package ${servicePackage};

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import ${domainClass};

public interface ${domainClassName}Service {
	
	public ${domainClassName} save(${domainClassName} ${domainClassName?uncap_first});
	
	public List<${domainClassName}> save(List<${domainClassName}> ${domainClassName?uncap_first}s);
	
	public void delete(${domainClassName} ${domainClassName?uncap_first});
	
	public void batchDelete(String[] ids);
	
	public ${domainClassName} findOne(${domainClassName} ${domainClassName?uncap_first});
	
	public List<${domainClassName}> findAll();
	
	public Page<${domainClassName}> pageQuery(Pageable pageable);
	
	public Page<${domainClassName}> pageQuery(Specification<${domainClassName}> specification,Pageable pageable);
	
}
