package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.entities.Technology;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private TechnologyService service;

    public TechnologiesController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<Technology> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Technology findById(int id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public void add(Technology technology) throws Exception {
        service.add(technology);
    }

    @PutMapping("/update")
    public void update(Technology technology, int id) throws Exception {
        service.update(technology, id);
    }

    @DeleteMapping("/remove")
    public void remove(int id) throws Exception {
        service.remove(id);
    }
}
