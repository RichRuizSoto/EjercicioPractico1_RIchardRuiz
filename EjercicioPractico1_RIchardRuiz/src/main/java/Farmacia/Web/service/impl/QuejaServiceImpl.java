package Farmacia.Web.service.impl;

import Farmacia.Web.dao.QuejaDao;
import Farmacia.Web.domain.Queja;
import Farmacia.Web.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaDao quejaDao;

    @Override
    public Queja guardarQueja(Queja queja) {
        return quejaDao.save(queja);
    }
}
