package com.br.authentication.jwt.init;

import com.br.authentication.jwt.domain.CargoEntity;
import com.br.authentication.jwt.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartAppCargo implements CommandLineRunner {

    private final CargoRepository cargoRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        CargoEntity cargoUser = new CargoEntity();
        cargoUser.setNome("ROLE_USER");

        CargoEntity cargoAdmin = new CargoEntity();
        cargoAdmin.setNome("ROLE_ADMIN");

        List<CargoEntity> cargoEntities = new ArrayList<>(List.of(cargoUser, cargoAdmin));

        cargoRepository.saveAll(cargoEntities);

    }
}
