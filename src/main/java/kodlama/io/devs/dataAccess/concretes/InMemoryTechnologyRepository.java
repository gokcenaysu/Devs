package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.Technology;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTechnologyRepository implements TechnologyRepository {
    List<Technology> technologies;

    public InMemoryTechnologyRepository() {
        technologies = new ArrayList<Technology>();
        technologies.add(new Technology(1,"Java"));
        technologies.add(new Technology(2,"Python"));
        technologies.add(new Technology(3,"Javascript"));
        technologies.add(new Technology(4,"C#"));    }


    @Override
    public List<Technology> getAll() {
        return technologies;
    }

    @Override
    public Technology findById(int id) {
        for (Technology tech : technologies)
            if(tech.getId()==id)
                return tech;
        return null;
    }

    @Override
    public void add(Technology technology) {
        technologies.add(technology);
    }

    @Override
    public void update(Technology technology, int id) {
        Technology tech = findById(id);
        tech.setName(tech.getName());
    }

    @Override
    public void delete(int id) {
        technologies.remove(id);
    }
}
