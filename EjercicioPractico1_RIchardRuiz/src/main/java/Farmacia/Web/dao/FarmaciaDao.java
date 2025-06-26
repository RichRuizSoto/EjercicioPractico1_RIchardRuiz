package Farmacia.Web.dao;

import Farmacia.Web.domain.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaDao extends JpaRepository <Farmacia,Long> {
    
}
