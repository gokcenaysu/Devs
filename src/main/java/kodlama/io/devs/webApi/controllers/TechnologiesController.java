package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.services.abstracts.TechnologyService;
import kodlama.io.devs.services.requests.CreateTechnologyRequest;
import kodlama.io.devs.services.responses.GetAllTechnologyResponse;
import kodlama.io.devs.models.Technology;
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
    public List<GetAllTechnologyResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Technology findById(int id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        service.add(createTechnologyRequest);
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
