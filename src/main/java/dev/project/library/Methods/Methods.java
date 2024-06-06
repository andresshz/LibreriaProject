package dev.project.library.Methods;
import java.util.List;



public interface Methods<T, P> {

    T create(P dto);
    List<T> findAll();
    T findById(int id);
  
}
