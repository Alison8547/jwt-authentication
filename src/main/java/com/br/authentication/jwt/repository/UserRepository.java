package com.br.authentication.jwt.repository;

import com.br.authentication.jwt.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findAllByActive(Integer integer);
}
