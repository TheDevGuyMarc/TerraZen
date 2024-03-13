package de.terrazen.zenbreeder.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
    Optional<AnimalEntity> findById(Long id);
}
