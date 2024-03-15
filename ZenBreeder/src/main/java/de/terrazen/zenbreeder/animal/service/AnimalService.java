package de.terrazen.zenbreeder.animal.service;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.animal.exception.AnimalNotFoundException;
import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.animal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAllAnimals() {
        return this.animalRepository.findAll()
            .stream()
            .map(Animal::new)
            .toList();
    }

    public Optional<Animal> findAnimalById(Long id) {
        return this.animalRepository.findById(id)
            .map(Animal::new);
    }

    public Animal createAnimal(Animal animal) {
        return new Animal(this.animalRepository.saveAndFlush(new AnimalEntity(animal)));
    }

    public Animal updateAnimal(Long id, Animal animal) {
        Optional<Animal> existingElement = this.animalRepository.findById(id)
            .map(Animal::new);

        if (existingElement.isPresent()) {
            Animal updatedElement = existingElement.get();

            updatedElement.setId(animal.getId());
            updatedElement.setName(animal.getName());
            updatedElement.setGender(animal.getGender());
            updatedElement.setAge(animal.getAge());
            updatedElement.setHatching_date(animal.getHatching_date());
            updatedElement.setLanding_date(animal.getLanding_date());
            updatedElement.setSize(animal.getSize());
            updatedElement.setBehaviour(animal.getBehaviour());
            updatedElement.setEgg_feeder(animal.isEgg_feeder());
            updatedElement.setBreedingGroup(animal.getBreedingGroup());
            updatedElement.setParentGroup(animal.getParentGroup());
            updatedElement.setSpecies(animal.getSpecies());
            updatedElement.setTraits(animal.getTraits());

            return new Animal(this.animalRepository.saveAndFlush(new AnimalEntity(updatedElement)));
        }
        else {
            throw new AnimalNotFoundException("Couldn't find the animal entry you requested with id: " + id);
        }
    }

    public void deleteAnimal(Long id) {
        this.animalRepository.deleteById(id);
    }
}
