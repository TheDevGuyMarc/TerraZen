package de.terrazen.zenbreeder.clutch.controller;

import de.terrazen.zenbreeder.clutch.domain.Clutch;
import de.terrazen.zenbreeder.clutch.service.ClutchService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clutches")
public class ClutchController {
    private final ClutchService clutchService;

    public ClutchController(ClutchService clutchService) {
        this.clutchService = clutchService;
    }

    @GetMapping
    public List<ClutchDTO> list() {
        return this.clutchService.findAllClutches()
            .stream()
            .map(ClutchDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public ClutchDTO read(@PathVariable @Min(1) Long id) {
        return this.clutchService.findClutchById(id)
            .map(ClutchDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public ClutchDTO create(@RequestBody @Valid @NotNull @NotEmpty Clutch clutch) {
        return new ClutchDTO(this.clutchService.createClutch(clutch));
    }

    @PutMapping("/{id}")
    public ClutchDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Clutch clutch) {
        return new ClutchDTO(this.clutchService.updateClutch(id, clutch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.clutchService.deleteClutch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
