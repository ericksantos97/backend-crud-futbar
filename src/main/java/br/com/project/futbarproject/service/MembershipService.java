package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.Membership;
import br.com.project.futbarproject.repository.MembershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Membership> findAllMemberships() {
        return this.membershipRepository.findAll();
    }

}
