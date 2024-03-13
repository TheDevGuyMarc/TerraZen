package de.terrazen.zenbreeder.clutch.service;

import de.terrazen.zenbreeder.clutch.domain.Clutch;
import de.terrazen.zenbreeder.clutch.exception.ClutchNotFoundException;
import de.terrazen.zenbreeder.clutch.repository.ClutchEntity;
import de.terrazen.zenbreeder.clutch.repository.ClutchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClutchService {
    private final ClutchRepository clutchRepository;

    public ClutchService(ClutchRepository clutchRepository) {
        this.clutchRepository = clutchRepository;
    }

    public List<Clutch> findAllClutches() {
        return this.clutchRepository.findAll()
            .stream()
            .map(Clutch::new)
            .toList();
    }

    public Optional<Clutch> findClutchById(Long id) {
        return this.clutchRepository.findById(id)
            .map(Clutch::new);
    }

    public Clutch createClutch(Clutch clutch) {
        return new Clutch(this.clutchRepository.saveAndFlush(new ClutchEntity(clutch)));
    }

    public Clutch updateClutch(Long id, Clutch clutch) {
        Optional<Clutch> existingElement = this.clutchRepository.findById(id)
            .map(Clutch::new);

        if (existingElement.isPresent()) {
            Clutch updatedElement = existingElement.get();

            updatedElement.setId(clutch.getId());
            updatedElement.setName(clutch.getName());
            updatedElement.setCondition(clutch.getCondition());
            updatedElement.setEgg_amount(clutch.getEgg_amount());

            return new Clutch(this.clutchRepository.saveAndFlush(new ClutchEntity(updatedElement)));
        }
        else {
            throw new ClutchNotFoundException("Couldn't find the clutch entry you requested with id: " + id);
        }
    }

    public void deleteClutch(Long id) {
        this.clutchRepository.deleteById(id);
    }
}
