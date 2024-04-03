package com.hiro.todohub.driver.config;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hiro.todohub.domain.data.user.RoleType;
import com.hiro.todohub.driver.persistence.entity.user.RoleEntity;
import com.hiro.todohub.driver.persistence.entity.user.UserEntity;
import com.hiro.todohub.driver.persistence.repository.user.RoleRepository;
import com.hiro.todohub.driver.persistence.repository.user.UserRepository;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<RoleEntity> roleAdmin = roleRepository.findByName(RoleType.ADMIN.name());
        Optional<UserEntity> userAdmin = userRepository.findByEmail("admin@admin.com");

        userAdmin.ifPresentOrElse(
            (user) -> {
                System.out.println("Admin já existe");
            },
            () -> {
                UserEntity user = new UserEntity
                    ("Admin", "admin@admin.com", passwordEncoder.encode("admin"),
                    "Rio de Janeiro", "Eu sou Admin", Set.of(roleAdmin.get()));

                userRepository.save(user);
            }
        );
    }
    
}