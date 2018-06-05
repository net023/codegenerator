package ${daoPackage};

import org.springframework.data.jpa.repository.JpaRepository;
import ${doaminPackage}.${doaminClassName};

public interface ${doaminClassName}Repository extends JpaRepository<${doaminClassName}, ${primaryKeyJavaType}> {

}