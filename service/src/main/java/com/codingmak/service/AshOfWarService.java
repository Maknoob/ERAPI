package com.codingmak.service;

import com.codingmak.model.*;
import com.codingmak.repositories.AshOfWarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AshOfWarService {

    @Autowired
    private AshOfWarRepository ashOfWarRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    public List<AshOfWar> search(Long id, String name, String skill, String affinity) {
        if (id != null) {
            return ashOfWarRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return ashOfWarRepository.findByNameContaining(name);
        }
        if (skill != null) {
            return ashOfWarRepository.findBySkillContaining(skill);
        }
        if (affinity != null) {
            return ashOfWarRepository.findByAffinityContaining(affinity);
        }
        return ashOfWarRepository.findAll();
    }

    public AshOfWar create(AshOfWar entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public AshOfWar save(AshOfWar entity) {
        return ashOfWarRepository.save(entity);
    }

    public AshOfWar update(Long id, AshOfWar entity) {
        AshOfWar was = ashOfWarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("War of Ashes not Found"));
        was.setName(entity.getName());
        was.setType(entity.getType());
        was.setDlc(entity.getDlc());
        was.setImage(entity.getImage());
        was.setSkill(entity.getSkill());
        was.setAffinity(entity.getAffinity());
        was.setAvailability(entity.getAvailability());
        was.setLocation(entity.getLocation());
        was.setSkillEffect(entity.getSkillEffect());


        return save(was);
    }

    public void deleteById(Long id) {
        ashOfWarRepository.deleteById(id);
    }

}
