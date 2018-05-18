package ${servicePackage}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${daoPackage}.${doaminClassName}Repository;
import ${doaminPackage}.${doaminClassName};
import ${servicePackage}.${doaminClassName}Service;

@Service
@Transactional
public class ${doaminClassName}ServiceImpl implements ${doaminClassName}Service {

	@Autowired
	private ${doaminClassName}Repository ${doaminClassName?uncap_first}Repository;

	@Override
	public ${doaminClassName} save(${doaminClassName} ${doaminClassName?uncap_first}) {
		return ${doaminClassName?uncap_first}Repository.save(${doaminClassName?uncap_first});
	}

	@Override
	public List<${doaminClassName}> save(List<${doaminClassName}> ${doaminClassName?uncap_first}s) {
		return ${doaminClassName?uncap_first}Repository.save(${doaminClassName?uncap_first}s);
	}

	@Override
	public void delete(${doaminClassName} ${doaminClassName?uncap_first}) {
		${doaminClassName?uncap_first}Repository.delete(${doaminClassName?uncap_first});
	}
	
	@Override
	public void batchDelete(String[] ids){
		for(String id : ids){
			${doaminClassName?uncap_first}Repository.delete(id);
		}
	}

	@Override
	public ${doaminClassName} findOne(${doaminClassName} ${doaminClassName?uncap_first}) {
		return ${doaminClassName?uncap_first}Repository.findOne(${doaminClassName?uncap_first}.get${primaryKeyJavaName}());
	}

	@Override
	public List<${doaminClassName}> findAll() {
		return ${doaminClassName?uncap_first}Repository.findAll();
	}

	@Override
	public Page<${doaminClassName}> pageQuery(Pageable pageable) {
		return ${doaminClassName?uncap_first}Repository.findAll(pageable);
	}

	@Override
	public Page<${doaminClassName}> pageQuery(Specification<${doaminClassName}> specification, Pageable pageable) {
		return ${doaminClassName?uncap_first}Repository.findAll(specification, pageable);
	}

}
