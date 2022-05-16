package br.com.fuzusnoary.passrepositoryapi.services;

import br.com.fuzusnoary.passrepositoryapi.dto.UserDTO;
import br.com.fuzusnoary.passrepositoryapi.entities.User;
import br.com.fuzusnoary.passrepositoryapi.repository.UserRepository;
import br.com.fuzusnoary.passrepositoryapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO findById(Long id) {
        return new UserDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao encontrar usuario")));
    }

    public UserDTO insert(UserDTO obj) {
        String shuffledString = TokenUtils.shuffle(obj.getPassword(), obj.getEmail());
        String token = TokenUtils.createToken(shuffledString);

        User user = new User(null, obj.getName(), obj.getEmail(), token);
        return new UserDTO(repository.save(user));
    }
}
