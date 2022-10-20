package za.ac.mycput.Service;

public interface IService<T, ID> {
    T save(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}