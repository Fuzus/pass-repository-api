package br.com.fuzusnoary.passrepositoryapi.services;

import br.com.fuzusnoary.passrepositoryapi.dto.UserDTO;
import br.com.fuzusnoary.passrepositoryapi.entities.Password;
import br.com.fuzusnoary.passrepositoryapi.entities.User;
import br.com.fuzusnoary.passrepositoryapi.entities.enums.PassType;
import br.com.fuzusnoary.passrepositoryapi.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository repository;

    @Autowired
    private UserService userService;

    public List<Password> findAll(String userToken) {
        UserDTO userDTO = userService.findById(userToken);
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setToken(userDTO.getToken());
        return repository.findByUser(user);
    }

    public Password findById(String userToken, Long id) {
        Password pass = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao encontrar senha"));
        if (!pass.getUser().getToken().equals(userToken))
            //TODO: alterar para exception 403 do http
            throw new RuntimeException("Usuario nao possui acesso a senha pedida");
        return pass;
    }

    public Password insert(String userToken, Password password) {
        UserDTO obj = userService.findById(userToken);
        User user = new User();
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setToken(obj.getToken());
        password.setUser(user);
        return repository.save(password);
    }

    public Password update(String userToken, Long id, Password password) {
        Password obj = findById(userToken, id);
        obj.setPassword(password.getPassword());
        obj.setPassType(PassType.valueOf(password.getPassType()));
        obj.setName(password.getName());
        return repository.save(obj);
    }

    public void delete(String userToken, Long id) {
        Password pass = findById(userToken, id);
        repository.delete(pass);
    }
}
