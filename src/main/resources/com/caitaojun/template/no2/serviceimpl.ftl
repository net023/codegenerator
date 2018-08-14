package ${servicePackage}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${daoPackage}.${domainClassName}Repository;
import ${domainClass};
import ${servicePackage}.${domainClassName}Service;

@Service
@Transactional
public class ${domainClassName}ServiceImpl implements ${domainClassName}Service {

	@Autowired
	private ${domainClassName}Repository ${domainClassName?uncap_first}Repository;

	@Override
	public ${domainClassName} save(${domainClassName} ${domainClassName?uncap_first}) {
		return ${domainClassName?uncap_first}Repository.save(${domainClassName?uncap_first});
	}

	@Override
	public List<${domainClassName}> save(List<${domainClassName}> ${domainClassName?uncap_first}s) {
		return ${domainClassName?uncap_first}Repository.save(${domainClassName?uncap_first}s);
	}

	@Override
	public void delete(${domainClassName} ${domainClassName?uncap_first}) {
		${domainClassName?uncap_first}Repository.delete(${domainClassName?uncap_first});
	}
	
	@Override
	public void batchDelete(String[] ids){
		for(String id : ids){
			${domainClassName?uncap_first}Repository.delete(${primaryKeyJavaType}.valueOf(id));
		}
	}

	@Override
	public ${domainClassName} findOne(${domainClassName} ${domainClassName?uncap_first}) {
		return ${domainClassName?uncap_first}Repository.findOne(${domainClassName?uncap_first}.get${primaryKeyName}());
	}

	@Override
	public List<${domainClassName}> findAll() {
		return ${domainClassName?uncap_first}Repository.findAll();
	}

	@Override
	public Page<${domainClassName}> pageQuery(Pageable pageable) {
		return ${domainClassName?uncap_first}Repository.findAll(pageable);
	}

	@Override
	public Page<${domainClassName}> pageQuery(Specification<${domainClassName}> specification, Pageable pageable) {
		return ${domainClassName?uncap_first}Repository.findAll(specification, pageable);
	}

}
