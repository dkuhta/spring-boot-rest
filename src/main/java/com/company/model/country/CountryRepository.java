package com.company.model.country;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 7/20/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
