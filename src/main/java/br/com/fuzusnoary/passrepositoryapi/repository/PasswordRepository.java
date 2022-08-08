package br.com.fuzusnoary.passrepositoryapi.repository;

import br.com.fuzusnoary.passrepositoryapi.entities.Password;
import br.com.fuzusnoary.passrepositoryapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<Password, Long> {

    List<Password> findByUser(User userToken);
}
