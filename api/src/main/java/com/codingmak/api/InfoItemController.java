package com.codingmak.api;

import com.codingmak.model.InfoItem;
import com.codingmak.service.InfoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/infoitems")
public class InfoItemController implements BaseController<InfoItem> {

    @Autowired
    private InfoItemService infoItemService;


    @Override
    public List<InfoItem> getAll() {
        return infoItemService.findAll();
    }

    @Override
    public Optional<InfoItem> getById(Long id) {
        return infoItemService.findById(id);
    }

    @Override
    public InfoItem update(Long id, InfoItem entity) {
        InfoItem infoItem = infoItemService.findById(id)
                .orElseThrow(() -> new RuntimeException("Info Item not found"));
        infoItem.setName(entity.getName());
        infoItem.setType(entity.getType());
        infoItem.setDlc(entity.getDlc());
        infoItem.setImage(entity.getImage());
        infoItem.setInformation(entity.getInformation());
        infoItem.setLocation(entity.getLocation());
        return infoItemService.save(infoItem);
    }

    @Override
    public InfoItem create(InfoItem entity) {
        return infoItemService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        infoItemService.deleteById(id);
    }
}
