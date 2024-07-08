package com.codingmak.service;

import com.codingmak.model.InfoItem;
import com.codingmak.repositories.InfoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoItemService {

    @Autowired
    private InfoItemRepository infoItemRepository;

    public List<InfoItem> findAllInfoItems() {
        return infoItemRepository.findAll();
    }

    public InfoItem saveInfoItem(InfoItem infoItem) {
        return infoItemRepository.save(infoItem);
    }

}
