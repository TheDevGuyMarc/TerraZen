package de.terrazen.zenbreeder.tank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnclosureRepository extends JpaRepository<EnclosureEntity, Long> {
    Optional<EnclosureEntity> findById(Long id);
}
