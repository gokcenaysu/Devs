package kodlama.io.devs.services.requireds;

import kodlama.io.devs.repositories.TechnologyRepository;
import kodlama.io.devs.models.Technology;
import org.springframework.stereotype.Service;

@Service
public class TechnologyFieldManager implements FieldService<Technology> {

    private final TechnologyRepository repository;

    public TechnologyFieldManager(TechnologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Technology findById(int id) throws Exception{
        return repository.findById(id).get();
    }

    @Override
    public void add(Technology technology) throws Exception{
        if(checkIfNameExists(technology.getName()))
            throw new Exception("That already exists");
        repository.save(technology);
    }

    @Override
    public void update(Technology technology) throws Exception {
        if(checkIfIdExists(technology.getId()))
            throw new Exception("No data");
        if(checkIfNameExists(technology.getName()))
            throw new Exception("That already exists");
        this.repository.save(technology);
    }

    @Override
    public void remove(Technology technology) throws Exception {
        if(checkIfIdExists(technology.getId()))
            throw new Exception("No data");
        this.repository.delete(technology);
    }

    private boolean checkIfNameExists(String name) throws Exception {
        return this.repository.findByName(name) != null;
    }

    private boolean checkIfIdExists(int id) throws Exception {
        return !this.repository.existsById(id);
    }
}
