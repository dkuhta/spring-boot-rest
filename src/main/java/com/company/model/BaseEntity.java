package com.company.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created on 7/20/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -131426822066475326L;

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Date dateCreated;

    private Date dateUpdated;
}
