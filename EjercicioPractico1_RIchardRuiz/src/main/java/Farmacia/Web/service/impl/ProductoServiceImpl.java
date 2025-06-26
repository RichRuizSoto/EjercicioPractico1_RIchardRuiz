package Farmacia.Web.service.impl;

import Farmacia.Web.dao.ProductoDao;
import Farmacia.Web.domain.Producto;
import Farmacia.Web.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> listarProductos() {
        return productoDao.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDao.deleteById(id);
    }
}
