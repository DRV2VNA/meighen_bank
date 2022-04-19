package io.meighen_bank_operationer.repository;

import io.meighen_bank_operationer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
