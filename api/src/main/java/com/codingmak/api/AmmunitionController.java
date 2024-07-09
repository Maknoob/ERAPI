package com.codingmak.api;

import com.codingmak.model.Ammunition;
import com.codingmak.service.AmmunitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ammunition")
public class AmmunitionController implements BaseController<Ammunition> {

    @Autowired
    private AmmunitionService ammunitionService;

    @Override
    public List<Ammunition> getAll() {
        return ammunitionService.findAll();
    }

    @Override
    public Optional<Ammunition> getById(Long id) {
        return ammunitionService.findById(id);
    }

    @Override
    public Ammunition update(Long id, Ammunition entity) {
        Ammunition ammunition = ammunitionService.findById(id)
                .orElseThrow(() -> new RuntimeException("Ammunition not found."));
        ammunition.setName(entity.getName());
        ammunition.setType(entity.getType());
        ammunition.setDlc(entity.getDlc());
        ammunition.setImage(entity.getImage());
        ammunition.setAttackPhy(entity.getAttackPhy());
        ammunition.setAttackMag(entity.getAttackMag());
        ammunition.setAttackFire(entity.getAttackFire());
        ammunition.setAttackLigt(entity.getAttackLigt());
        ammunition.setAttackHoly(entity.getAttackHoly());
        ammunition.setAttackCrit(entity.getAttackCrit());
        ammunition.setPassive(entity.getPassive());

        return ammunitionService.save(ammunition);
    }

    @Override
    public Ammunition create(Ammunition entity) {
        return ammunitionService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ammunitionService.deleteById(id);
    }
}
