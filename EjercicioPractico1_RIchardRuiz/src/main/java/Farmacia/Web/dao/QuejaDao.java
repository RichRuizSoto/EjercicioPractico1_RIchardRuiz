package Farmacia.Web.dao;

import Farmacia.Web.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuejaDao extends JpaRepository<Queja, Long> {}
