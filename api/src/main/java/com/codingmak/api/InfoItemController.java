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
    public List<InfoItem> getAllInfoItems() {
        return infoItemService.findAllInfoItems();
    }

    @PostMapping
    public InfoItem createInfoItem(@RequestBody InfoItem infoItem) {
        return infoItemService.saveInfoItem(infoItem);
    }
}
