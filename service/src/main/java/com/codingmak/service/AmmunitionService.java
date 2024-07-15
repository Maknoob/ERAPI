package com.codingmak.service;

import com.codingmak.model.Ammunition;
import com.codingmak.repositories.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmmunitionService {

    @Autowired
    private AmmunitionRepository ammunitionRepository;


    public List<Ammunition> search(Long id, String name) {
        if (id != null) {
            return ammunitionRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return ammunitionRepository.findByNameContaining(name);
        }
        return ammunitionRepository.findAll();
    }


    public Ammunition save(Ammunition entity) {
        return ammunitionRepository.save(entity);
    }

    public void deleteById(Long id) {
        ammunitionRepository.deleteById(id);
    }

    public Ammunition update(Long id, Ammunition entity) {
        Ammunition ammunition = ammunitionRepository.findById(id)
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
        return save(ammunition);
    }
}
