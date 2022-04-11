package be.technifutur.sportaddict.controllers;

import be.technifutur.sportaddict.dto.FitnessDTO;
import be.technifutur.sportaddict.forms.FitnessForm;
import be.technifutur.sportaddict.service.FitnessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fitness")
public class FitnessController {
    private final FitnessService service;

    public FitnessController(FitnessService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<FitnessDTO> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public FitnessDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping("/owner/{id}")
    public List<FitnessDTO> getByOwner(@PathVariable Long id) {
        return service.findByOwnerId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FitnessDTO> delete(@PathVariable Long id){
        return service.deleteOne(id) != null ?
                ResponseEntity.ok(null) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<FitnessDTO> insert(@Valid @RequestBody FitnessForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("{id}")
    public ResponseEntity<FitnessDTO> update(@PathVariable Long id,@Valid @RequestBody FitnessForm form){
        return ResponseEntity.ok(service.updateOne(id,form));
    }
}
