package com.company.model.person;

import com.company.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created on 7/20/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
@Entity
public class Person extends BaseEntity {

    private static final long serialVersionUID = -2418502014132867307L;

    private String username;
    private String password;
}

