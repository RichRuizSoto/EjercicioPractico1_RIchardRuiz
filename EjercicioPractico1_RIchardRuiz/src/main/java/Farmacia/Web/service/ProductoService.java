package Farmacia.Web.service;

import Farmacia.Web.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();
    Producto guardarProducto(Producto producto);
    Producto obtenerProducto(Long id);
    void eliminarProducto(Long id);
}
