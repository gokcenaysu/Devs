package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.models.SubTechnology;
import kodlama.io.devs.services.abstracts.SubTechnologyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-technologies")
public class SubTechnologiesController {
    private SubTechnologyService service;

    public SubTechnologiesController(SubTechnologyService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<SubTechnology> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public SubTechnology findById(@RequestParam int id){
        return this.service.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SubTechnology subTechnology) {
        this.service.add(subTechnology);
    }

    @PutMapping("/update")
    public void update(@RequestBody SubTechnology subTechnology, int id) throws Exception{
        this.service.update(subTechnology,id);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestParam int id) throws Exception{
        this.service.remove(id);
    }
}
