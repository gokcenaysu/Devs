package kodlama.io.devs.services.abstracts;

import kodlama.io.devs.services.requests.CreateTechnologyRequest;
import kodlama.io.devs.services.responses.GetAllTechnologyResponse;
import kodlama.io.devs.models.Technology;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();

    Technology findById(int id);

    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;

    void update(Technology technology, int id) throws Exception;

    void remove(int id) throws Exception;
}
