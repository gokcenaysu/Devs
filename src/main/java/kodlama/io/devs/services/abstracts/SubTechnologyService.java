package kodlama.io.devs.services.abstracts;

import kodlama.io.devs.models.SubTechnology;

import java.util.List;

public interface SubTechnologyService {
    List<SubTechnology> getAll();
    SubTechnology findById(int id);

    void add(SubTechnology subTechnology);
    void update(SubTechnology subTechnology,int id) throws Exception;
    void remove(int id) throws Exception;
}
