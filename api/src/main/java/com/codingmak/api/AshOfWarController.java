package com.codingmak.api;

import com.codingmak.model.AshOfWar;
import com.codingmak.service.AshOfWarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/ashesofwar")
public class AshOfWarController implements PpdInterface<AshOfWar> {

    @Autowired
    private AshOfWarService ashOfWarService;


    @GetMapping
    public Object search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "skill", required = false) String skill,
            @RequestParam(value = "affinity", required = false) String affinity,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false) Integer size) {

        if (page == null || size == null) {
            int totalSize = (int) ashOfWarService.getCount();
            return new RedirectView(String.format("/ashesofwar?page=0&size=%d", totalSize));
        }

        Pageable pageable = PageRequest.of(page, size);
        return ashOfWarService.search(id, name, skill, affinity, pageable);
    }

    @Override
    public AshOfWar create(AshOfWar entity) {
        return ashOfWarService.create(entity);
    }

    @Override
    public AshOfWar update(Long id, AshOfWar entity) {
        return ashOfWarService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        ashOfWarService.deleteById(id);
    }
}
