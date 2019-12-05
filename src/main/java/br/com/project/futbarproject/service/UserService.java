package br.com.project.futbarproject.service;

import br.com.project.futbarproject.entity.User;
import br.com.project.futbarproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User findByEmailAndPassword(User user) {

        Optional<User> entity = Optional.ofNullable(this.userRepository.findOptionalByEmailAndPassword(user.getEmail(), user.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado.")));

        if (entity.isPresent()) {
            user.setId(entity.get().getId());
            user.setName(entity.get().getName());
            user.setEmail(entity.get().getEmail());
            user.setPassword(entity.get().getPassword());
        }

        return user;
    }

}
