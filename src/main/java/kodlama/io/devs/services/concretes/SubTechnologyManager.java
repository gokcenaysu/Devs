package kodlama.io.devs.services.concretes;

import kodlama.io.devs.dataAccess.repositories.SubTechnologyRepository;
import kodlama.io.devs.models.SubTechnology;
import kodlama.io.devs.services.abstracts.SubTechnologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTechnologyManager implements SubTechnologyService {

    private SubTechnologyRepository repository;

    public SubTechnologyManager(SubTechnologyRepository repository) {
        this.repository = repository;
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
    public void add(SubTechnology subTechnology) {
        this.repository.save(subTechnology);
    }

    @Override
    public void update(SubTechnology subTechnology, int id) throws Exception {
        SubTechnology subTech = repository.getReferenceById(id);
        subTech.setName(subTechnology.getName());
        repository.save(subTech);
    }

    @Override
    public void remove(int id) {
        this.repository.deleteById(id);
    }
}
