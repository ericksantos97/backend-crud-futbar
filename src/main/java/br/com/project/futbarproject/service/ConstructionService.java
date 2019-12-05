package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.Construction;
import br.com.project.futbarproject.repository.ConstructionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ConstructionService {

    private final ConstructionRepository constructionRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Construction> findAllConstructions() {

        return this.constructionRepository.findAll();
    }

}
