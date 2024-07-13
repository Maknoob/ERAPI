package com.codingmak.api;

import com.codingmak.model.InfoItem;
import com.codingmak.service.InfoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infoitems")
public class InfoItemController {

    @Autowired
    private InfoItemService infoItemService;

    @GetMapping
    public List<InfoItem> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return infoItemService.search(id, name, type);
    }

    /* @Override
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
    } */
}
