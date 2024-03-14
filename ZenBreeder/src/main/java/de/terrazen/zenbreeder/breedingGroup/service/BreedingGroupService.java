package de.terrazen.zenbreeder.breedingGroup.service;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.breedingGroup.exception.BreedingGroupNotFoundException;
import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedingGroupService {
    private final BreedingGroupRepository breedingGroupRepository;

    public BreedingGroupService(BreedingGroupRepository breedingGroupRepository) {
        this.breedingGroupRepository = breedingGroupRepository;
    }

    public List<BreedingGroup> findAllBreedingGroups() {
        return this.breedingGroupRepository.findAll()
            .stream()
            .map(BreedingGroup::new)
            .toList();
    }

    public Optional<BreedingGroup> findBreedingGroupById(Long id) {
        return this.breedingGroupRepository.findById(id)
            .map(BreedingGroup::new);
    }

    public BreedingGroup createBreedingGroup(BreedingGroup breedingGroup) {
        return new BreedingGroup(this.breedingGroupRepository.saveAndFlush(new BreedingGroupEntity(breedingGroup)));
    }

    public BreedingGroup updateBreedingGroup(Long id, BreedingGroup breedingGroup) {
        Optional<BreedingGroup> existingElement = this.breedingGroupRepository.findById(id)
            .map(BreedingGroup::new);

        if (existingElement.isPresent()) {
            BreedingGroup updatedElement = existingElement.get();

            updatedElement.setId(breedingGroup.getId());
            updatedElement.setName(breedingGroup.getName());
            updatedElement.setDescription(breedingGroup.getDescription());
            updatedElement.setPaired_at(breedingGroup.getPaired_at());
            updatedElement.setAnimal_amount(breedingGroup.getAnimal_amount());
            updatedElement.setEnclosure(breedingGroup.getEnclosure());
            updatedElement.setAnimals(breedingGroup.getAnimals());
            updatedElement.setClutches(breedingGroup.getClutches());
            updatedElement.setOffspring(breedingGroup.getOffspring());
            updatedElement.setNotes(breedingGroup.getNotes());

            return new BreedingGroup(this.breedingGroupRepository.saveAndFlush(new BreedingGroupEntity(updatedElement)));
        }
        else {
            throw new BreedingGroupNotFoundException("Couldn't find the breeding-group entry you requested with id: " + id);
        }
    }

    public void deleteBreedingGroup(Long id) {
        this.breedingGroupRepository.deleteById(id);
    }
}
