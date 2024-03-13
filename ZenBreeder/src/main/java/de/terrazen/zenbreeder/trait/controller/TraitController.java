package de.terrazen.zenbreeder.trait.controller;

import de.terrazen.zenbreeder.trait.domain.Trait;
import de.terrazen.zenbreeder.trait.service.TraitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traits")
public class TraitController {
    private final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @GetMapping
    public List<TraitDTO> list() {
        return this.traitService.findAllTraits()
            .stream()
            .map(TraitDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public TraitDTO read(@PathVariable @Min(1) Long id) {
        return this.traitService.findTraitById(id)
            .map(TraitDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public TraitDTO create(@RequestBody @Valid @NotNull @NotEmpty Trait trait) {
        return new TraitDTO(this.traitService.createTrait(trait));
    }

    @PutMapping("/{id}")
    public TraitDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Trait trait) {
        return new TraitDTO(this.traitService.updateTrait(id, trait));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.traitService.deleteTrait(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
