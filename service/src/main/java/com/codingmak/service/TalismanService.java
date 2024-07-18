package com.codingmak.service;

import com.codingmak.model.Talisman;
import com.codingmak.repositories.TalismanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalismanService {

    @Autowired
    private TalismanRepository talismanRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    public List<Talisman> search(Long id, String name) {
        if (id != null) {
            return talismanRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return talismanRepository.findByNameContaining(name);
        }
        return talismanRepository.findAll();
    }

    public Talisman create(Talisman entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public Talisman save(Talisman entity) {
        return talismanRepository.save(entity);
    }

    public void deleteById(Long id) {
        talismanRepository.deleteById(id);
    }

    public Talisman update(Long id, Talisman entity) {
        Talisman talisman = talismanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talisman with ID: " + id + " not found"));
        talisman.setName(entity.getName());
        talisman.setType(entity.getType());
        talisman.setDlc(entity.getDlc());
        talisman.setImage(entity.getImage());
        talisman.setWeight(entity.getWeight());
        talisman.setEffect(entity.getEffect());
        return save(talisman);
    }
}
