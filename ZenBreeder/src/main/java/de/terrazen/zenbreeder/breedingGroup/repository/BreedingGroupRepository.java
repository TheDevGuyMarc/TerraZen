package de.terrazen.zenbreeder.breedingGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreedingGroupRepository extends JpaRepository<BreedingGroupEntity, Long> {
    Optional<BreedingGroupEntity> findById(Long id);
}
