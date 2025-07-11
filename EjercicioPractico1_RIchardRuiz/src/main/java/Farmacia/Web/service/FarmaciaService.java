/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Farmacia.Web.service;


import Farmacia.Web.domain.Farmacia;
import java.util.List;

public interface FarmaciaService {

    public List<Farmacia> getCategorias(boolean activo);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Farmacia getCategoria(Farmacia categoria);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Farmacia categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Farmacia categoria);
}
 