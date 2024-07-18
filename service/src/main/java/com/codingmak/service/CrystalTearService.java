package com.codingmak.service;

import com.codingmak.model.CrystalTear;
import com.codingmak.repositories.CrystalTearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrystalTearService {

    @Autowired
    private CrystalTearRepository crystalTearRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;


    public List<CrystalTear> search(Long id, String name, String type) {
        if (id != null) {
            return crystalTearRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return crystalTearRepository.findByNameContaining(name);
        }
        if (type != null) {
            return crystalTearRepository.findByTypeContaining(type);
        }
        return crystalTearRepository.findAll();
    }

    public CrystalTear create(CrystalTear entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public CrystalTear save(CrystalTear entity) {
        return crystalTearRepository.save(entity);
    }

    public void deleteById(Long id) {
        crystalTearRepository.deleteById(id);
    }

    public CrystalTear update(Long id, CrystalTear entity) {
        CrystalTear crystalTear = crystalTearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crystal Tear not found."));
        crystalTear.setName(entity.getName());
        crystalTear.setType(entity.getType());
        crystalTear.setDlc(entity.getDlc());
        crystalTear.setImage(entity.getImage());
        crystalTear.setLocation(entity.getLocation());
        crystalTear.setDurationInSec(entity.getDurationInSec());
        crystalTear.setWhenUsed(entity.getWhenUsed());
        return save(crystalTear);
    }
}
