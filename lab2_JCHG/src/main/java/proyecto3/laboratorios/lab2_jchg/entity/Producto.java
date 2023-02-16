package proyecto3.laboratorios.lab2_jchg.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TABLA_PRODUCTO")
// Aca me cambia el nombre de "Producto" a "Tabla_Producto".
public class Producto {
    // Necesita tener una llave primaria.
    @Id
    // Esto es para que autogenere la llave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Esto es para que el campo sea obligatorio (que no pueda ser null).
    @Column(nullable = false)
    private String nombre;


    private String descripcion;

    private Integer cantidad;

    @Column(nullable = false)
    private Integer precio;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, Integer cantidad, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}



