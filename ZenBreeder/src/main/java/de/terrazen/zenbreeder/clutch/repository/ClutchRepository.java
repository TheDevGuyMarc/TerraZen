package de.terrazen.zenbreeder.clutch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClutchRepository extends JpaRepository<ClutchEntity, Long> {
    Optional<ClutchEntity> findById(Long id);
}
