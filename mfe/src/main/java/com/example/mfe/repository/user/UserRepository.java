package com.example.mfe.repository.user;

import com.example.mfe.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsrSso(String usrSso);

}
