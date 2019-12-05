package br.com.project.futbarproject.repository;

import br.com.project.futbarproject.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
