package de.terrazen.zenbreeder.species.service;

import de.terrazen.zenbreeder.species.domain.Species;
import de.terrazen.zenbreeder.species.exception.SpeciesNotFoundException;
import de.terrazen.zenbreeder.species.repository.SpeciesEntity;
import de.terrazen.zenbreeder.species.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public List<Species> findAllSpeciess() {
        return this.speciesRepository.findAll()
            .stream()
            .map(Species::new)
            .toList();
    }

    public Optional<Species> findSpeciesById(Long id) {
        return this.speciesRepository.findById(id)
            .map(Species::new);
    }

    public Species createSpecies(Species species) {
        return new Species(this.speciesRepository.saveAndFlush(new SpeciesEntity(species)));
    }

    public Species updateSpecies(Long id, Species species) {
        Optional<Species> existingElement = this.speciesRepository.findById(id)
            .map(Species::new);

        if (existingElement.isPresent()) {
            Species updatedElement = existingElement.get();

            updatedElement.setId(species.getId());
            updatedElement.setName(species.getName());
            updatedElement.setDescription(species.getDescription());
            updatedElement.setAnimals(species.getAnimals());

            return new Species(this.speciesRepository.saveAndFlush(new SpeciesEntity(updatedElement)));
        }
        else {
            throw new SpeciesNotFoundException("Couldn't find the species entry you requested with id: " + id);
        }
    }

    public void deleteSpecies(Long id) {
        this.speciesRepository.deleteById(id);
    }
}
