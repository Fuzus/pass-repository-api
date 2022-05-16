package br.com.fuzusnoary.passrepositoryapi.repository;

import br.com.fuzusnoary.passrepositoryapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
