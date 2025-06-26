/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmacia.Web.service.impl;


import Farmacia.Web.domain.Farmacia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Farmacia.Web.dao.FarmaciaDao;
import Farmacia.Web.service.FarmaciaService;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

     @Autowired
    private FarmaciaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Farmacia getCategoria(Farmacia categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Farmacia categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Farmacia categoria) {
        categoriaDao.delete(categoria);
    }
    
}
 