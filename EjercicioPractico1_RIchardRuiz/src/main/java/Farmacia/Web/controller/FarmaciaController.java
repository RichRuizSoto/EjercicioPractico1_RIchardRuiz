package Farmacia.Web.controller;

import Farmacia.Web.domain.Farmacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import Farmacia.Web.service.FarmaciaService;

@Controller
@RequestMapping("/categoria")
public class FarmaciaController {

    @Autowired
    private FarmaciaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";
    }

    @GetMapping("/nuevo")
    public String categoriaNuevo(Farmacia categoria) {
        return "/categoria/modifica";
    }

    // Descomenta e inyecta el servicio de Firebase si lo vas a usar
    // @Autowired
    // private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String categoriaGuardar(Farmacia categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            // Si usas Firebase, carga la imagen y asigna la ruta
            // categoria.setRutaImagen(
            //     firebaseStorageService.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria())
            // );
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Farmacia categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Farmacia categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}
