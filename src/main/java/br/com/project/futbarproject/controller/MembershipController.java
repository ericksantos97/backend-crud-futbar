package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.Membership;
import br.com.project.futbarproject.service.MembershipService;
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
@RequestMapping(path =  "/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping
    public List<Membership> findAll() {
        return this.membershipService.findAllMemberships();
    }
}
