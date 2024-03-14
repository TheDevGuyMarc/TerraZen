package de.terrazen.zenbreeder.animal.controller;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.animal.service.AnimalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalDTO> list() {
        return this.animalService.findAllAnimals()
            .stream()
            .map(AnimalDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public AnimalDTO read(@PathVariable @Min(1) Long id) {
        return this.animalService.findAnimalById(id)
            .map(AnimalDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public AnimalDTO create(@RequestBody @Valid @NotNull @NotEmpty Animal animal) {
        return new AnimalDTO(this.animalService.createAnimal(animal));
    }

    @PutMapping("/{id}")
    public AnimalDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Animal animal) {
        return new AnimalDTO(this.animalService.updateAnimal(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.animalService.deleteAnimal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
