package kodlama.io.devs.services.requireds;

import kodlama.io.devs.models.SubTechnology;
import kodlama.io.devs.repositories.SubTechnologyRepository;
import org.springframework.stereotype.Service;

@Service
public class SubTechnologyFieldManager implements FieldService<SubTechnology>{

    private final SubTechnologyRepository repository;

    public SubTechnologyFieldManager(SubTechnologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public SubTechnology findById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public void add(SubTechnology subTechnology) throws Exception {
        if(checkIfNameExists(subTechnology.getName()))
            throw new Exception("That already exists");
        repository.save(subTechnology);
    }

    @Override
    public void update(SubTechnology subTechnology) throws Exception {
        if(checkIfIdExists(subTechnology.getId()))
            throw new Exception("No data");
        if(checkIfNameExists(subTechnology.getName()))
            throw new Exception("That already exists");
        this.repository.save(subTechnology);
    }

    @Override
    public void remove(SubTechnology subTechnology) throws Exception {
        if(checkIfIdExists(subTechnology.getId()))
            throw new Exception("No data");
        this.repository.delete(subTechnology);
    }

    private boolean checkIfNameExists(String name) throws Exception {
        return this.repository.findByName(name) != null;
    }

    private boolean checkIfIdExists(int id) throws Exception {
        return !this.repository.existsById(id);
    }
}

