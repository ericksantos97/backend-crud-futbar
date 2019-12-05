package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.Region;
import br.com.project.futbarproject.service.RegionService;
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
@RequestMapping(path = "/regions", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public List<Region> findAll() {
        return this.regionService.findAllRegions();
    }

}
