package kodlama.io.devs.services.concretes;

import kodlama.io.devs.models.Technology;
import kodlama.io.devs.repositories.SubTechnologyRepository;
import kodlama.io.devs.models.SubTechnology;
import kodlama.io.devs.services.abstracts.SubTechnologyService;
import kodlama.io.devs.services.requireds.FieldService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTechnologyManager implements SubTechnologyService {

    private SubTechnologyRepository repository;
    private FieldService<SubTechnology> fieldService;


    public SubTechnologyManager(SubTechnologyRepository repository, FieldService<SubTechnology> fieldService) {
        this.repository = repository;
        this.fieldService=fieldService;
    }

    @Override
    public List<SubTechnology> getAll() {
        return this.repository.findAll();
    }

    @Override
    public SubTechnology findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(SubTechnology subTechnology) throws Exception{
        this.fieldService.add(subTechnology);
    }

    @Override
    public void update(SubTechnology subTechnology) throws Exception {
        this.fieldService.update(subTechnology);
    }

    @Override
    public void remove(SubTechnology subTechnology) throws Exception{
        this.fieldService.remove(subTechnology);
    }
}
