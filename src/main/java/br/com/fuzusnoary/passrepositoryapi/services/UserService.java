package br.com.fuzusnoary.passrepositoryapi.services;

import br.com.fuzusnoary.passrepositoryapi.dto.UserDTO;
import br.com.fuzusnoary.passrepositoryapi.entities.User;
import br.com.fuzusnoary.passrepositoryapi.repository.UserRepository;
import br.com.fuzusnoary.passrepositoryapi.services.exceptions.ObjectNotFoundException;
import br.com.fuzusnoary.passrepositoryapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO findUser(String email, String password) {
        String shuffledStr = TokenUtils.shuffle(password, email);
        String id = TokenUtils.createToken(shuffledStr);
        return new UserDTO(repository.findByToken(id));
    }

    public UserDTO findUser(Long id) {
        return new UserDTO(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Erro ao encontrar usuario")));
    }

    public UserDTO insert(UserDTO obj) {
        String shuffledString = TokenUtils.shuffle(obj.getPassword(), obj.getEmail());
        String token = TokenUtils.createToken(shuffledString);

        User user = new User(null, obj.getName(), obj.getEmail(), token);
        return new UserDTO(repository.save(user));
    }
}
