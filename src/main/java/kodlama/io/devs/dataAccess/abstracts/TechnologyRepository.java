package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.Technology;

import java.util.List;

public interface TechnologyRepository {
    List<Technology> getAll();
    Technology findById (int id);

    void add(Technology technology);
    void update(Technology technology, int id);
    void delete(int id);

}
