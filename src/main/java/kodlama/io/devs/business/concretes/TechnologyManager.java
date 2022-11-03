package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository repository;

    public TechnologyManager(TechnologyRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Technology> getAll() {
        return repository.getAll();
    }

    @Override
    public Technology findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void add(Technology technology) throws Exception {
        for (Technology tech: repository.getAll()) {
            if (tech.getName().equals(technology.getName()))
                throw new Exception("That already exists");

            else if (technology.getName().isBlank() || technology.getName().isBlank())
                throw new Exception("The field cannot empty");
        }
        repository.add(technology);
    }

    @Override
    public void update(Technology technology, int id) throws Exception {
        Technology tech = repository.findById(id);
        if(tech == null)
            throw new Exception("No data");
        repository.update(technology, id);
    }

    @Override
    public void remove(int id) throws Exception {
        Technology tech = repository.findById(id);
        if(tech == null)
            throw new Exception("No data");
        repository.delete(id);
    }
}
