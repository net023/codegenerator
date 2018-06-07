package ${daoPackage};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ${domainClass};

public interface ${domainClassName}Repository extends JpaRepository<${domainClassName}, ${primaryKeyJavaType}>,
	JpaSpecificationExecutor<${domainClassName}> {

}