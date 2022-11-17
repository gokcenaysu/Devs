package kodlama.io.devs.services.abstracts;

import kodlama.io.devs.services.requests.CreateTechnologyRequest;
import kodlama.io.devs.services.responses.GetAllTechnologyResponse;
import kodlama.io.devs.models.Technology;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();

    Technology findById(int id) throws Exception;

    void add(Technology technology) throws Exception;

    void update(Technology technology) throws Exception;

    void remove(Technology technology) throws Exception;
}
