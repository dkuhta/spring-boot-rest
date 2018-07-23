package com.company.model.country;

import com.company.model.country.Country;
import com.company.model.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 7/23/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@RestController
@RequestMapping("/countries")
public class CountryRestController {

    private CountryService service;

    @Autowired
    public void setService(final CountryService service) {
        this.service = service;
    }

    @GetMapping
    private List<Country> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    private Country get(@PathVariable Long id) {
        return service.get(id);
    }
}
