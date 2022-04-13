package be.technifutur.sportaddict.controllers;

import be.technifutur.sportaddict.dto.SubsDTO;
import be.technifutur.sportaddict.service.SubsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
