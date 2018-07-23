package com.company.model.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created on 7/20/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Long> {

}
