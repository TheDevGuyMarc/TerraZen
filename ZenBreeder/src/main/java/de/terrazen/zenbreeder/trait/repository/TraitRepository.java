package de.terrazen.zenbreeder.trait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraitRepository extends JpaRepository<TraitEntity, Long> {
    Optional<TraitEntity> findById(Long id);
}
