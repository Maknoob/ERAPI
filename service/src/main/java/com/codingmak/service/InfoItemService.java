package com.codingmak.service;

import com.codingmak.model.InfoItem;
import com.codingmak.repositories.InfoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoItemService {

    @Autowired
    private InfoItemRepository infoItemRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    public List<InfoItem> search(Long id, String name, String type) {
        if (id != null) {
            return infoItemRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return infoItemRepository.findByNameContaining(name);
        }
        if (type != null) {
            return infoItemRepository.findByTypeContaining(type);
        }
        return infoItemRepository.findAll();
    }

    public InfoItem create(InfoItem entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public InfoItem save(InfoItem entity) {
        return infoItemRepository.save(entity);
    }

    public void deleteById(Long id) {
        infoItemRepository.deleteById(id);
    }

    public InfoItem update(Long id, InfoItem entity) {
        InfoItem infoItem = infoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Info Item not found"));
        infoItem.setName(entity.getName());
        infoItem.setType(entity.getType());
        infoItem.setDlc(entity.getDlc());
        infoItem.setImage(entity.getImage());
        infoItem.setInformation(entity.getInformation());
        infoItem.setLocation(entity.getLocation());
        return save(infoItem);
    }
}
