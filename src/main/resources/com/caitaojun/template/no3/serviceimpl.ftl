package ${servicePackage}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${doaminPackage}.${doaminClassName};
import ${servicePackage}.${doaminClassName}Service;
import ${daoPackage}.${doaminClassName}Mapper;

@Service
@Transactional
public class ${doaminClassName}ServiceImpl implements ${doaminClassName}Service {

	@Autowired
	private ${doaminClassName}Mapper ${doaminClassName?uncap_first}Dao;

	@Override
	public ${doaminClassName} save(${doaminClassName} ${doaminClassName?uncap_first}) {
		${doaminClassName?uncap_first}Dao.insertSelective(${doaminClassName?uncap_first});
		return ${doaminClassName?uncap_first};
	}

	@Override
	public List<${doaminClassName}> save(List<${doaminClassName}> ${doaminClassName?uncap_first}s) {
		for (${doaminClassName} ${doaminClassName?uncap_first} : ${doaminClassName?uncap_first}s) {
			${doaminClassName?uncap_first}Dao.insertSelective(${doaminClassName?uncap_first});
		}
		return ${doaminClassName?uncap_first}s;
	}

	@Override
	public void delete(${doaminClassName} ${doaminClassName?uncap_first}) {
		${doaminClassName?uncap_first}Dao.deleteByPrimaryKey(${doaminClassName?uncap_first}.get${primaryKeyName}());
	}
	
	@Override
	public void batchDelete(String[] ids){
		for(String id : ids){
			${doaminClassName?uncap_first}Dao.deleteByPrimaryKey(${primaryKeyType}.valueOf(id));
		}
	}

	@Override
	public ${doaminClassName} findOne(${doaminClassName} ${doaminClassName?uncap_first}) {
		return ${doaminClassName?uncap_first}Dao.selectByPrimaryKey(${doaminClassName?uncap_first}.get${primaryKeyName}());
	}
	
	@Override
	public List<${doaminClassName}> findPageData(${doaminClassName} pojo,Integer pageNumber,Integer pageSize) {
		return ${doaminClassName?uncap_first}Dao.selectPageBySelective(pojo, (pageNumber-1)*pageSize, pageSize);
	}

	@Override
	public Integer selectCount(${doaminClassName} ${doaminClassName?uncap_first}) {
		return ${doaminClassName?uncap_first}Dao.selectCount(${doaminClassName?uncap_first});
	}

}
