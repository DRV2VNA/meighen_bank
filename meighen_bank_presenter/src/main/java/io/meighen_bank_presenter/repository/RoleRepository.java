package io.meighen_bank_presenter.repository;

import io.meighen_bank_presenter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
