package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.Construction;
import br.com.project.futbarproject.service.ConstructionService;
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
@RequestMapping(path = "/constructions", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConstructionController {

    private final ConstructionService constructionService;

    @GetMapping
    public List<Construction> findAll() {
        return this.constructionService.findAllConstructions();
    }

}
