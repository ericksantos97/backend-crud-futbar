package br.com.project.futbarproject.repository;

import br.com.project.futbarproject.entity.Construction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstructionRepository extends JpaRepository<Construction, Long> {
}
