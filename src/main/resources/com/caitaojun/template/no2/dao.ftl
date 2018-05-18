package ${daoPackage};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import ${doaminPackage}.${doaminClassName};

public interface ${doaminClassName}Repository extends JpaRepository<${doaminClassName}, ${primaryKeyJavaType}>,
		JpaSpecificationExecutor<${doaminClassName}>,QueryByExampleExecutor<${doaminClassName}> {

}