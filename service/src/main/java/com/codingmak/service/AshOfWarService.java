package com.codingmak.service;

import com.codingmak.model.*;
import com.codingmak.repositories.AshOfWarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AshOfWarService {

    @Autowired
    private AshOfWarRepository ashOfWarRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    @Autowired
    private PagedResourcesAssembler<AshOfWar> pagedResourcesAssembler;

    public long getCount() {
        return ashOfWarRepository.count();
    }

    public PagedModel<?> getPaginatedAshOfWars(Pageable pageable) {
        Page<AshOfWar> ashOfWarPage = ashOfWarRepository.findAll(pageable);
        return pagedResourcesAssembler.toModel(ashOfWarPage);
    }

    public PagedModel<?> search(Long id, String name, String skill, String affinity, Pageable pageable) {
        Page<AshOfWar> ashOfWarPage;
        if (id != null) {
            Optional<AshOfWar> ashOfWar = ashOfWarRepository.findById(id);
            ashOfWarPage = ashOfWar.map(aow -> new PageImpl<>(Collections.singletonList(aow), pageable, 1))
                    .orElse(new PageImpl<>(Collections.emptyList(), pageable, 0));
        } else if (name != null) {
            ashOfWarPage = ashOfWarRepository.findByNameContaining(name, pageable);
        } else if (skill != null) {
            ashOfWarPage = ashOfWarRepository.findBySkillContaining(skill, pageable);
        } else if (affinity != null) {
            ashOfWarPage = ashOfWarRepository.findByAffinityContaining(affinity, pageable);
        } else {
            ashOfWarPage = ashOfWarRepository.findAll(pageable);
        }
        return pagedResourcesAssembler.toModel(ashOfWarPage);
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
