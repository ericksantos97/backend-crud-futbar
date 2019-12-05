package br.com.project.futbarproject.repository;

import br.com.project.futbarproject.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
