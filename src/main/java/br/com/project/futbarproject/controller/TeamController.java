package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.Team;
import br.com.project.futbarproject.model.TeamResponse;
import br.com.project.futbarproject.response.Response;
import br.com.project.futbarproject.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/team", produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
public class TeamController {

    private final TeamService teamService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Team>> create(@Valid @RequestBody final Team team) {
        Response<Team> response = new Response<Team>();

        try {
            Team entity = this.teamService.createOrUpdateTeam(null, team);
            response.setResult(entity);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Team>> update(@PathVariable final Long id, @Valid @RequestBody final Team team) {
        Response<Team> response = new Response<Team>();

        try {
            Team entity = this.teamService.createOrUpdateTeam(id, team);
            response.setResult(entity);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        try {
            this.teamService.deleteTeam(id);
            return ResponseEntity.status(HttpStatus.OK).body("Registro excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel completar a exclusão, tente mais tarde.");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<TeamResponse>> findAllTeams() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.teamService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }

    }

    @GetMapping("/findTeam/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable final Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.teamService.findTeamById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Team());
        }
    }

}
