package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.Equipment;
import br.com.project.futbarproject.service.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> findAll() {
        return this.equipmentService.findAllEquipments();
    }
}
