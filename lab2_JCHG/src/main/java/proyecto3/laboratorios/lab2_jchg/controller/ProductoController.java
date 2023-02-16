package proyecto3.laboratorios.lab2_jchg.controller;

import proyecto3.laboratorios.lab2_jchg.entity.Producto;
import proyecto3.laboratorios.lab2_jchg.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {


    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("productos")
    public List<Producto> getAllProductos(){
        return  productoRepository.findAll();
    }


    // Obtener el producto por ID
    // El optional es para que no nos retorne un null exception
    @GetMapping("productos/{id}")
    public Optional<Producto> getProductos(@PathVariable(value = "id") Integer id){
        return  productoRepository.findById(id);
    }


    @PostMapping("producto")
    public Producto addProducto(@RequestBody Producto producto){
        return  productoRepository.save(producto);
    }

    @DeleteMapping("productos/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable(value ="id") Integer id){
        productoRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Integer id, @RequestBody Producto productoUpdate){

        Optional<Producto> Producto = productoRepository.findById(id);

        Producto.get().setNombre(productoUpdate.getNombre());
        Producto.get().setDescripcion(productoUpdate.getDescripcion());
        Producto.get().setCantidad(productoUpdate.getCantidad());
        Producto.get().setPrecio(productoUpdate.getPrecio());

        Producto updatedProducto = productoRepository.save(Producto.get());

        return ResponseEntity.ok(updatedProducto);

    }


    // Busqueda por nombre
    @GetMapping("productosNombre/{nombre}")
    public List<Producto> getEstudiante(@PathVariable(value = "nombre") String nombre){
        return  productoRepository.findByNombre(nombre);
    }






}
