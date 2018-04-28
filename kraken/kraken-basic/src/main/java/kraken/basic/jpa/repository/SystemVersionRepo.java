package kraken.basic.jpa.repository;

import kraken.basic.jpa.orm.SystemVersion;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemVersionRepo extends JpaRepository<SystemVersion, Integer>, Specification<SystemVersion> {
}
