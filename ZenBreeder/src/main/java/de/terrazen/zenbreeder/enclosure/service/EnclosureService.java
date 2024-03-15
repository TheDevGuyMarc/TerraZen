package de.terrazen.zenbreeder.enclosure.service;

import de.terrazen.zenbreeder.enclosure.domain.Enclosure;
import de.terrazen.zenbreeder.enclosure.exception.EnclosureNotFoundException;
import de.terrazen.zenbreeder.enclosure.repository.EnclosureEntity;
import de.terrazen.zenbreeder.enclosure.repository.EnclosureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnclosureService {
    private final EnclosureRepository enclosureRepository;

    public EnclosureService(EnclosureRepository enclosureRepository) {
        this.enclosureRepository = enclosureRepository;
    }

    public List<Enclosure> findAllEnclosures() {
        return this.enclosureRepository.findAll()
            .stream()
            .map(Enclosure::new)
            .toList();
    }

    public Optional<Enclosure> findEnclosureById(Long id) {
        return this.enclosureRepository.findById(id)
            .map(Enclosure::new);
    }

    public Enclosure createEnclosure(Enclosure enclosure) {
        return new Enclosure(this.enclosureRepository.saveAndFlush(new EnclosureEntity(enclosure)));
    }

    public Enclosure updateEnclosure(Long id, Enclosure enclosure) {
        Optional<Enclosure> existingElement = this.enclosureRepository.findById(id)
            .map(Enclosure::new);

        if (existingElement.isPresent()) {
            Enclosure updatedElement = existingElement.get();

            updatedElement.setId(enclosure.getId());
            updatedElement.setName(enclosure.getName());
            updatedElement.setWidth(enclosure.getWidth());
            updatedElement.setHeight(enclosure.getHeight());
            updatedElement.setDepth(enclosure.getDepth());
            updatedElement.setHabitat(enclosure.getHabitat());
            updatedElement.setTemperature(enclosure.getTemperature());
            updatedElement.setHumidity(enclosure.getHumidity());
            updatedElement.setBreedingGroups(enclosure.getBreedingGroups());

            return new Enclosure(this.enclosureRepository.saveAndFlush(new EnclosureEntity(updatedElement)));
        }
        else {
            throw new EnclosureNotFoundException("Couldn't find the enclosure entry you requested with id: " + id);
        }
    }

    public void deleteEnclosure(Long id) {
        this.enclosureRepository.deleteById(id);
    }
}
