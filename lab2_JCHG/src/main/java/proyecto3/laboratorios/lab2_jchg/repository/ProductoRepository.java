package proyecto3.laboratorios.lab2_jchg.repository;

import proyecto3.laboratorios.lab2_jchg.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// <Estudiante> define de quien y luego se le pasa el parametro de como en este caso el ID.
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

    // Si quiero hacer consulta personalizada hago funciones

    // Encontrar cuantos productos tengo almacenados.
    @Query("select COUNT(p) from Producto p")
    public int findCount();

    // Hacer busqueda por un campo especifico.

    // Encontrar uno o los productos por su  nombre.
    // Signo de "?1" porque voy a usar el parametro del query el parametro  el parametro que tengo de la funcion.
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByNombre(String nombre);

    // Obtener cuantos productos existen por nombre
    @Query("select p.nombre from Producto p group by  p.nombre" )
    List<Object[]> findAllByNombre();
}
