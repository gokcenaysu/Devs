package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.Technology;

import java.util.List;

public interface TechnologyService {
    List<Technology> getAll();

    Technology findById(int id);

    void add(Technology technology) throws Exception;

    void update(Technology technology, int id) throws Exception;

    void remove(int id) throws Exception;
}
