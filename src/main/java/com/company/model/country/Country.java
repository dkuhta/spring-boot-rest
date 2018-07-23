package com.company.model.country;

import com.company.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Created on 7/20/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
@Entity
public class Country extends BaseEntity {

    private static final long serialVersionUID = -9171280139473224408L;

    private String name;

    @JsonIgnore
    private int square;
}
