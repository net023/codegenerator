package ${servicePackage}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${domainPackage}.${domainClassName};
import ${servicePackage}.${domainClassName}Service;
import ${daoPackage}.${domainClassName}Mapper;

@Service
@Transactional
public class ${domainClassName}ServiceImpl implements ${domainClassName}Service {

	@Autowired
	private ${domainClassName}Mapper ${domainClassName?uncap_first}Dao;

	@Override
	public ${domainClassName} save(${domainClassName} ${domainClassName?uncap_first}) {
		if(${domainClassName?uncap_first}.get${primaryKeyName}()==null){
			${domainClassName?uncap_first}Dao.insertSelective(${domainClassName?uncap_first});
		}else{
			${domainClassName?uncap_first}Dao.updateByPrimaryKeySelective(${domainClassName?uncap_first});
		}
		return ${domainClassName?uncap_first};
	}

	@Override
	public List<${domainClassName}> save(List<${domainClassName}> ${domainClassName?uncap_first}s) {
		for (${domainClassName} ${domainClassName?uncap_first} : ${domainClassName?uncap_first}s) {
			${domainClassName?uncap_first}Dao.insertSelective(${domainClassName?uncap_first});
		}
		return ${domainClassName?uncap_first}s;
	}

	@Override
	public void delete(${domainClassName} ${domainClassName?uncap_first}) {
		${domainClassName?uncap_first}Dao.deleteByPrimaryKey(${domainClassName?uncap_first}.get${primaryKeyName}());
	}
	
	@Override
	public void batchDelete(String[] ids){
		for(String id : ids){
			${domainClassName?uncap_first}Dao.deleteByPrimaryKey(${primaryKeyJavaType}.valueOf(id));
		}
	}

	@Override
	public ${domainClassName} findOne(${domainClassName} ${domainClassName?uncap_first}) {
		return ${domainClassName?uncap_first}Dao.selectByPrimaryKey(${domainClassName?uncap_first}.get${primaryKeyName}());
	}
	
	@Override
	public List<${domainClassName}> findPageData(${domainClassName} pojo,Integer pageNumber,Integer pageSize,String sort,String order) {
		return ${domainClassName?uncap_first}Dao.selectPageBySelective(pojo, (pageNumber-1)*pageSize, pageSize, sort, order);
	}

	@Override
	public Integer selectCount(${domainClassName} ${domainClassName?uncap_first}) {
		return ${domainClassName?uncap_first}Dao.selectCount(${domainClassName?uncap_first});
	}

}
