package com.codingmak.api;

import com.codingmak.model.Talisman;
import com.codingmak.service.TalismanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talismans")
public class TalismanController implements PpdInterface<Talisman> {

    @Autowired
    private TalismanService talismanService;

    @GetMapping
    public List<Talisman> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name) {
        return talismanService.search(id, name);
    }

    @Override
    public Talisman create(Talisman entity) {
        return talismanService.create(entity);
    }

    @Override
    public Talisman update(Long id, Talisman entity) {
        return talismanService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        talismanService.deleteById(id);
    }
}
