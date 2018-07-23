package com.company.model.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 7/23/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository repository;

    @Autowired
    public CountryServiceImpl(final CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> get() {
        return repository.findAll();
    }

    @Override
    public Country get(final Long id) {
        return repository.getOne(id);
    }
}
