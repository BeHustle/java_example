import java.util.ArrayList;

public interface IStore<T, I> {
    void add(T object);


    T get(I id) throws IllegalArgumentException;


    ArrayList<T> getAll();
}
