package com.br.authentication.jwt.init;

import com.br.authentication.jwt.domain.User;
import com.br.authentication.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class StartApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User user = userRepository.findByUsername("admin");

        if (user == null) {

            user = new User();
            user.setName("Alison");
            user.setUsername("admin");
            String encode = bCryptPasswordEncoder.encode("123");
            user.setPassword(encode);

            user.getRoles().add("MANAGERS");

            userRepository.save(user);
        }


        user = userRepository.findByUsername("user");

        if (user == null) {
            user = new User();
            user.setName("Saulo");
            user.setUsername("user");
            String encode = bCryptPasswordEncoder.encode("321");
            user.setPassword(encode);
            user.getRoles().add("USERS");

            userRepository.save(user);
        }

    }
}
