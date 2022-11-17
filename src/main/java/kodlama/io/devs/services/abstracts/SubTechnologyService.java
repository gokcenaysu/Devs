package kodlama.io.devs.services.abstracts;

import kodlama.io.devs.models.SubTechnology;

import java.util.List;

public interface SubTechnologyService {
    List<SubTechnology> getAll();
    SubTechnology findById(int id);

    void add(SubTechnology subTechnology) throws Exception;
    void update(SubTechnology subTechnology) throws Exception;
    void remove(SubTechnology subTechnology) throws Exception;
}
