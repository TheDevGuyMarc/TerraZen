package de.terrazen.zenbreeder.breedingGroup.controller;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.breedingGroup.service.BreedingGroupService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enclosures")
public class BreedingGroupController {
    private final BreedingGroupService breedingGroupService;

    public BreedingGroupController(BreedingGroupService breedingGroupService) {
        this.breedingGroupService = breedingGroupService;
    }

    @GetMapping
    public List<BreedingGroupDTO> list() {
        return this.breedingGroupService.findAllBreedingGroups()
            .stream()
            .map(BreedingGroupDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public BreedingGroupDTO read(@PathVariable @Min(1) Long id) {
        return this.breedingGroupService.findBreedingGroupById(id)
            .map(BreedingGroupDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public BreedingGroupDTO create(@RequestBody @Valid @NotNull @NotEmpty BreedingGroup breedingGroup) {
        return new BreedingGroupDTO(this.breedingGroupService.createBreedingGroup(breedingGroup));
    }

    @PutMapping("/{id}")
    public BreedingGroupDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty BreedingGroup breedingGroup) {
        return new BreedingGroupDTO(this.breedingGroupService.updateBreedingGroup(id, breedingGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.breedingGroupService.deleteBreedingGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
