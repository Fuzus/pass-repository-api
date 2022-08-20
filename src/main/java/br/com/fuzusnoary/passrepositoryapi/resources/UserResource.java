package br.com.fuzusnoary.passrepositoryapi.resources;

import br.com.fuzusnoary.passrepositoryapi.dto.UserDTO;
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

    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO user) {
        UserDTO obj = service.findUser(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(obj);
    }

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<UserDTO> login(String email, String password) {
        UserDTO obj = service.findUser(email, password);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO userDTO = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user.getToken()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<UserDTO> createUser(String name, String email, String password) {
        UserDTO obj = new UserDTO(name, email, password);
        UserDTO userDTO = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(userDTO.getToken()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }
}
