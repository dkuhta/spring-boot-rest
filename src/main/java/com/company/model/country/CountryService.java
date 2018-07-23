package com.company.model.country;

import java.util.List;

/**
 * Created on 7/23/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public interface CountryService {

    List<Country> get();

    Country get(Long id);
}
