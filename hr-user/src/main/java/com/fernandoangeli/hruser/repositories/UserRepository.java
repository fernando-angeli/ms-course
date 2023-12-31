package com.fernandoangeli.hruser.repositories;

import com.fernandoangeli.hruser.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
