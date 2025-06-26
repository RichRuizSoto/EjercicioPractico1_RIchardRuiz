package Farmacia.Web.controller;

import Farmacia.Web.domain.Producto;
import Farmacia.Web.domain.Categoria;
import Farmacia.Web.domain.Queja;
import Farmacia.Web.service.ProductoService;
import Farmacia.Web.service.CategoriaService;
import Farmacia.Web.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FarmaciaController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private QuejaService quejaService;

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "categoria/listado";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categoria/fragmentos";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/queja")
    public String quejaForm(Model model) {
        model.addAttribute("queja", new Queja());
        return "queja/formulario";
    }

    @PostMapping("/queja/enviar")
    public String enviarQueja(@ModelAttribute Queja queja) {
        quejaService.guardarQueja(queja);
        return "redirect:/";
    }
}
