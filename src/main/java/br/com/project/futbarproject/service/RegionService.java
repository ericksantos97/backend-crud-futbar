package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.Region;
import br.com.project.futbarproject.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Region> findAllRegions() {
        return this.regionRepository.findAll();
    }

}
