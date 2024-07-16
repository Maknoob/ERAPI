package com.codingmak.service;

import com.codingmak.model.Ammunition;
import com.codingmak.model.Attack;
import com.codingmak.repositories.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Ammunition create(Ammunition entity) {
        if (entity.getId() != null) {
            Optional<Ammunition> existingAmmunition = ammunitionRepository.findById(entity.getId());
            if (existingAmmunition.isPresent()) {
                throw new RuntimeException("Ammunition with ID " + entity.getId() + " already exists.");
            }
        }
        return save(entity);
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
        ammunition.setPassive(entity.getPassive());

        if (ammunition.getAttack() == null) {
            ammunition.setAttack(new Attack());
        }
        ammunition.getAttack().setPhysical(entity.getAttack().getPhysical());
        ammunition.getAttack().setMagical(entity.getAttack().getMagical());
        ammunition.getAttack().setFire(entity.getAttack().getFire());
        ammunition.getAttack().setLightning(entity.getAttack().getLightning());
        ammunition.getAttack().setHoly(entity.getAttack().getHoly());
        ammunition.getAttack().setCritical(entity.getAttack().getCritical());

        return save(ammunition);
    }
}
