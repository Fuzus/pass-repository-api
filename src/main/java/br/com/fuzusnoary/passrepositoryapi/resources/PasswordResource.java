package br.com.fuzusnoary.passrepositoryapi.resources;

import br.com.fuzusnoary.passrepositoryapi.entities.Password;
import br.com.fuzusnoary.passrepositoryapi.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "{user_token}")
    public ResponseEntity<List<Password>> findAll(@PathVariable("user_token") String user_token){
        List<Password> list = service.findAll(user_token);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{user_token}/{id}")
    public ResponseEntity<Password> findById(@PathVariable("user_token") String userToken, @PathVariable Long id) {
        Password obj = service.findById(userToken, id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(path ="/{user_token}")
    public ResponseEntity<Password> createPass(@PathVariable("user_token") String userToken, @RequestBody Password password) {
        password = service.insert(userToken, password);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(password.getId()).toUri();
        return ResponseEntity.created(uri).body(password);
    }

    @PutMapping(path = "/{user_token}/{id}")
    public ResponseEntity<Password> updatePass(@PathVariable("user_token") String userToken, @PathVariable Long id, @RequestBody Password password) {
        Password obj = service.update(userToken, id, password);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(path = "/{user_token}/{id}")
    public ResponseEntity<Void> deletePass(@PathVariable("user_token") String userToken ,@PathVariable Long id) {
        service.delete(userToken, id);
        return ResponseEntity.noContent().build();
    }
}
