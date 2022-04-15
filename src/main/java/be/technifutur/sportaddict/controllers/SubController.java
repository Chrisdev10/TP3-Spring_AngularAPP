package be.technifutur.sportaddict.controllers;

import be.technifutur.sportaddict.dto.SubsDTO;
import be.technifutur.sportaddict.forms.SubsForm;
import be.technifutur.sportaddict.service.SubsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sub")
public class SubController {

    private final SubsService service;

    public SubController(SubsService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    SubsDTO getOneByClientID(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping("")
    List<SubsDTO> getAll(){
        return service.getAll();
    }

    @PostMapping("")
    SubsDTO addOne(@RequestBody SubsForm sub){
        return service.addOne(sub);
    }

    @DeleteMapping("{id}")
    SubsDTO delete(@PathVariable Long id){
        return service.deleteOne(id);
    }

    @PutMapping("{id}")
    SubsDTO update(@PathVariable Long id, @RequestBody SubsForm form){
        return service.update(id, form);
    }


}
