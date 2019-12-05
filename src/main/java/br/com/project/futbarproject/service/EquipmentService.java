package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.Equipment;
import br.com.project.futbarproject.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Equipment> findAllEquipments() {
        return this.equipmentRepository.findAll();
    }


}
