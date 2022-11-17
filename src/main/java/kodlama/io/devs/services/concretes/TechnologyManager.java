package kodlama.io.devs.services.concretes;

import kodlama.io.devs.services.abstracts.TechnologyService;
import kodlama.io.devs.services.requireds.FieldService;
import kodlama.io.devs.services.responses.GetAllTechnologyResponse;
import kodlama.io.devs.repositories.TechnologyRepository;
import kodlama.io.devs.models.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository repository;
    private FieldService<Technology> fieldService;

    public TechnologyManager(TechnologyRepository repository,FieldService<Technology> fieldService) {
        this.repository = repository;
        this.fieldService = fieldService;
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
    public Technology findById(int id) throws Exception {
        return this.fieldService.findById(id);
    }

    @Override
    public void add(Technology technology) throws Exception {
        this.fieldService.add(technology);
    }

    @Override
    public void update(Technology technology) throws Exception {
       this.fieldService.update(technology);

    }

    @Override
    public void remove(Technology technology) throws Exception {
        this.fieldService.remove(technology);
    }
}
