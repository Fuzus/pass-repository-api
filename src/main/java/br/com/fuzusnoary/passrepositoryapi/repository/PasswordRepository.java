package br.com.fuzusnoary.passrepositoryapi.repository;

import br.com.fuzusnoary.passrepositoryapi.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
