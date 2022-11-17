package kodlama.io.devs.services.requireds;

public interface FieldService<T> {

     T findById(int id) throws Exception;
     void add (T data) throws Exception;
     void update (T data) throws Exception;
     void remove (T data) throws Exception;
}
