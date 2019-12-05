package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.Team;
import br.com.project.futbarproject.model.TeamResponse;
import br.com.project.futbarproject.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository teamRepository;

    @Transactional
    public Team createOrUpdateTeam(Long id, final Team team) {

        Boolean teamWhitServant = this.teamRepository.existsTeamByNameAndId(team.getName(), team.getId());

        Boolean teamWhithName = this.teamRepository.existsTeamByName(team.getName());


        if (((id == null) ? 0 : id) > 0) {

                Optional<Team> entity = this.teamRepository.findById(id);

                if (entity.isPresent()) {

                    entity = Optional.ofNullable(Team.builder()
                            .id(team.getId())
                            .name(team.getName())
                            .initials(team.getInitials())
                            .membership_id(team.getMembership_id())
                            .construction_id(team.getConstruction_id())
                            .equipment_id(team.getEquipment_id())
                            .region_id(team.getRegion_id())
                            .build());

                    return this.teamRepository.saveAndFlush(entity.get());
                }

        } else if (teamWhithName && ObjectUtils.isEmpty(team.getId())) {

            throw new RuntimeException("Time já cadastrado, por favor altere o nome e tente novamente.");

        } else {

            Optional<Team> entity = Optional.ofNullable(Team.builder()
                    .name(team.getName())
                    .initials(team.getInitials())
                    .membership_id(team.getMembership_id())
                    .construction_id(team.getConstruction_id())
                    .equipment_id(team.getEquipment_id())
                    .region_id(team.getRegion_id())
                    .build());

            if (entity.isPresent()) {

                return this.teamRepository.saveAndFlush(entity.get());
            }
        }

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTeam(Long id) {
        this.teamRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<TeamResponse> findAll() {
        return this.teamRepository.findAllTeams();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Team findTeamById(final Long id) {
        return this.teamRepository.findUniqueTeam(id);
    }

}
