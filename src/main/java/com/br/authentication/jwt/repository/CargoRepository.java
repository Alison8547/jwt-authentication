package com.br.authentication.jwt.repository;

import com.br.authentication.jwt.domain.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {
}
