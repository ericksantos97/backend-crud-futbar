package br.com.project.futbarproject.controller;

import br.com.project.futbarproject.entity.User;
import br.com.project.futbarproject.response.Response;
import br.com.project.futbarproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/findUser")
    public ResponseEntity<Response<User>> findUserToLogin(@Valid @RequestBody User user) {
        Response<User> response = new Response<User>();

        try {
            User entity = this.userService.findByEmailAndPassword(user);
            response.setResult(entity);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
