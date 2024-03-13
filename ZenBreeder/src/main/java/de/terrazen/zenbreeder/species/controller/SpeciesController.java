package de.terrazen.zenbreeder.species.controller;

import de.terrazen.zenbreeder.species.domain.Species;
import de.terrazen.zenbreeder.species.service.SpeciesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<SpeciesDTO> list() {
        return this.speciesService.findAllSpeciess()
            .stream()
            .map(SpeciesDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public SpeciesDTO read(@PathVariable @Min(1) Long id) {
        return this.speciesService.findSpeciesById(id)
            .map(SpeciesDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public SpeciesDTO create(@RequestBody @Valid @NotNull @NotEmpty Species species) {
        return new SpeciesDTO(this.speciesService.createSpecies(species));
    }

    @PutMapping("/{id}")
    public SpeciesDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Species species) {
        return new SpeciesDTO(this.speciesService.updateSpecies(id, species));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.speciesService.deleteSpecies(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
