package de.terrazen.zenbreeder.trait.service;

import de.terrazen.zenbreeder.trait.domain.Trait;
import de.terrazen.zenbreeder.trait.exception.TraitNotFoundException;
import de.terrazen.zenbreeder.trait.repository.TraitEntity;
import de.terrazen.zenbreeder.trait.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitService {
    private final TraitRepository traitRepository;

    public TraitService(TraitRepository traitRepository) {
        this.traitRepository = traitRepository;
    }

    public List<Trait> findAllTraits() {
        return this.traitRepository.findAll()
            .stream()
            .map(Trait::new)
            .toList();
    }

    public Optional<Trait> findTraitById(Long id) {
        return this.traitRepository.findById(id)
            .map(Trait::new);
    }

    public Trait createTrait(Trait trait) {
        return new Trait(this.traitRepository.saveAndFlush(new TraitEntity(trait)));
    }

    public Trait updateTrait(Long id, Trait trait) {
        Optional<Trait> existingElement = this.traitRepository.findById(id)
            .map(Trait::new);

        if (existingElement.isPresent()) {
            Trait updatedElement = existingElement.get();

            updatedElement.setId(trait.getId());
            updatedElement.setName(trait.getName());
            updatedElement.setColoration(trait.getColoration());
            updatedElement.setHomozygous(trait.isHomozygous());
            updatedElement.setHeterozygous(trait.isHeterozygous());
            updatedElement.setMedical_position(trait.getMedical_position());
            updatedElement.setCoDominant(trait.isCoDominant());
            updatedElement.setDominant(trait.isDominant());
            updatedElement.setRecessive(trait.isRecessive());
            updatedElement.setAnimals(trait.getAnimals());

            return new Trait(this.traitRepository.saveAndFlush(new TraitEntity(updatedElement)));
        }
        else {
            throw new TraitNotFoundException("Couldn't find the trait entry you requested with id: " + id);
        }
    }

    public void deleteTrait(Long id) {
        this.traitRepository.deleteById(id);
    }
}
