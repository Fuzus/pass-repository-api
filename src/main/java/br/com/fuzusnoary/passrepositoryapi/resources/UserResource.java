package br.com.fuzusnoary.passrepositoryapi.resources;

import br.com.fuzusnoary.passrepositoryapi.dto.UserDTO;
import br.com.fuzusnoary.passrepositoryapi.dto.UserReturnableDTO;
import br.com.fuzusnoary.passrepositoryapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/Authentication")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<UserReturnableDTO> login(String email, String password) {
        UserReturnableDTO obj = new UserReturnableDTO(service.findUser(email, password));
        return ResponseEntity.ok(obj);
    }

    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<UserReturnableDTO> createUser(String name, String email, String password) {
        UserDTO obj = new UserDTO(null, name, email, password);
        UserReturnableDTO userDTO = new UserReturnableDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(userDTO.getToken()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserReturnableDTO> login(@RequestBody UserDTO user) {
        return login(user.getEmail(), user.getPassword());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserReturnableDTO> createUser(@RequestBody UserDTO user) {
        return createUser(user.getName(), user.getEmail(), user.getPassword());
    }

}
