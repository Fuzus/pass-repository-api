package br.com.fuzusnoary.passrepositoryapi.resources;

import br.com.fuzusnoary.passrepositoryapi.entities.Password;
import br.com.fuzusnoary.passrepositoryapi.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/passwords")
public class PasswordResource {

    @Autowired
    private PasswordService service;

    @GetMapping
    public ResponseEntity<List<Password>> findAll(@RequestHeader("user_token") String user_token) {
        List<Password> list = service.findAll(user_token);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Password> findById(@RequestHeader("user_token") String userToken, @PathVariable Long id) {
        Password obj = service.findById(userToken, id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Password> createPass(@RequestHeader("user_token") String userToken, String name, int passType, String pass) {
        Password password = new Password(0L, name, passType, pass);
        password = service.insert(userToken, password);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(password.getId()).toUri();
        return ResponseEntity.created(uri).body(password);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Password> createPassword(@RequestHeader("user_token") String userToken, @RequestBody Password password) {
        password = service.insert(userToken, password);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(password.getId()).toUri();
        return ResponseEntity.created(uri).body(password);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Password> updatePass(@RequestHeader("user_token") String userToken, @PathVariable Long id, @RequestBody Password password) {
        Password obj = service.update(userToken, id, password);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Password> updatePassword(@RequestHeader("user_token") String userToken, @PathVariable Long id, String name, int passType, String pass) {
        Password password = new Password(0L, name, passType, pass);
        Password obj = service.update(userToken, id, password);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePass(@RequestHeader("user_token") String userToken, @PathVariable Long id) {
        service.delete(userToken, id);
        return ResponseEntity.noContent().build();
    }
}
