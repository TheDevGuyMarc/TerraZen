package de.terrazen.zenbreeder.tank.controller;

import de.terrazen.zenbreeder.tank.domain.Enclosure;
import de.terrazen.zenbreeder.tank.service.EnclosureService;
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
public class EnclosureController {
    private final EnclosureService enclosureService;

    public EnclosureController(EnclosureService enclosureService) {
        this.enclosureService = enclosureService;
    }

    @GetMapping
    public List<EnclosureDTO> list() {
        return this.enclosureService.findAllEnclosures()
            .stream()
            .map(EnclosureDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public EnclosureDTO read(@PathVariable @Min(1) Long id) {
        return this.enclosureService.findEnclosureById(id)
            .map(EnclosureDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public EnclosureDTO create(@RequestBody @Valid @NotNull @NotEmpty Enclosure enclosure) {
        return new EnclosureDTO(this.enclosureService.createEnclosure(enclosure));
    }

    @PutMapping("/{id}")
    public EnclosureDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Enclosure enclosure) {
        return new EnclosureDTO(this.enclosureService.updateEnclosure(id, enclosure));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.enclosureService.deleteEnclosure(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
