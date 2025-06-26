package Farmacia.Web.service.impl;

import Farmacia.Web.dao.CategoriaDao;
import Farmacia.Web.domain.Categoria;
import Farmacia.Web.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaDao.findAll();
    }
}
