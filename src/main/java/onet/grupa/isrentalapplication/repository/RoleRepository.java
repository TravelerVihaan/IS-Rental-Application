package onet.grupa.isrentalapplication.repository;

import onet.grupa.isrentalapplication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
