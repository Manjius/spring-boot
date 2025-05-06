package com.jonandroid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(
            @PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerbyId(id);
    }

    @PostMapping
    public void addEngineer(@RequestBody SoftwareEngineer engineer){
        softwareEngineerService.addSoftwareEngineer(engineer);
    }

    @DeleteMapping("{id}")
    public void deleteEngineerById(
            @PathVariable Integer id
    ){
        softwareEngineerService.deleteSoftwareEngineerbyId(id);
    }

    @PutMapping("{id}")
    public void modifyEngineerById(
            @PathVariable Integer id , @RequestBody SoftwareEngineer engineer
    ){
        softwareEngineerService.modifySoftwareEngineerbyId(id, engineer);
    }

}
