package br.com.project.futbarproject.repository;

import br.com.project.futbarproject.entity.Team;
import br.com.project.futbarproject.model.TeamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Boolean existsTeamByNameAndId(String name, Long id);

    Boolean existsTeamByName(String name);

    @Query("SELECT new br.com.project.futbarproject.model.TeamResponse(" +
            "t.id, t.initials, t.name, c.description, e.description, m.name, r.description " +
            ") \n" +
            "FROM Team t " +
            "  LEFT JOIN Membership m ON t.membership_id = m.id\n" +
            "  LEFT JOIN Equipment e ON t.equipment_id = e.id\n" +
            "  LEFT JOIN Construction c ON t.construction_id = c.id\n" +
            "  LEFT JOIN Region r ON t.region_id = r.id GROUP BY t.id")
    List<TeamResponse> findAllTeams();

    @Query("SELECT t FROM Team t WHERE t.id = :id")
    Team findUniqueTeam(final Long id);


}
