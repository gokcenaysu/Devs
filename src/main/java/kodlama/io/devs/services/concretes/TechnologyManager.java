package kodlama.io.devs.services.concretes;

import kodlama.io.devs.services.abstracts.TechnologyService;
import kodlama.io.devs.services.requests.CreateTechnologyRequest;
import kodlama.io.devs.services.responses.GetAllTechnologyResponse;
import kodlama.io.devs.dataAccess.repositories.TechnologyRepository;
import kodlama.io.devs.models.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository repository;

    public TechnologyManager(TechnologyRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = repository.findAll();
        List<GetAllTechnologyResponse> technologyResponse = new ArrayList<GetAllTechnologyResponse>();

        for (Technology technology : technologies){
            GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());

            technologyResponse.add(responseItem);
        }
        return technologyResponse;
    }

    @Override
    public Technology findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());

        this.repository.save(technology);
       /* for (Technology tech: repository.getAll()) {
            if (tech.getName().equals(technology.getName()))
                throw new Exception("That already exists");

            if (technology.getName().isBlank() || technology.getName().isBlank())
                throw new Exception("The field cannot empty");
        }
        repository.add(technology);*/
    }

    @Override
    public void update(Technology technology, int id) throws Exception {
        Technology tech = repository.getReferenceById(technology.getId());
        if(tech.getName().isEmpty()) {
            throw new Exception("No data");
        }
        tech.setName(technology.getName());
        repository.save(tech);
       /* Technology tech = repository.findById(id);
        if(tech == null)
            throw new Exception("No data");
        repository.update(technology,id);*/
    }

    @Override
    public void remove(int id) throws Exception {
        Technology tech = repository.getReferenceById(id);
        if(tech == null)
            throw new Exception("No data");
        repository.deleteById(id);
    }
}
