package com.br.authentication.jwt.service;

import com.br.authentication.jwt.domain.CargoEntity;
import com.br.authentication.jwt.exception.BusinessException;
import com.br.authentication.jwt.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;


    public CargoEntity findCargo(Integer idCargo) {
        return cargoRepository.findById(idCargo)
                .orElseThrow(() -> new BusinessException("Cargo not found!"));
    }
}
