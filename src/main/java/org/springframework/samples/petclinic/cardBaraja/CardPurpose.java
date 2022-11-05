package org.springframework.samples.petclinic.cardBaraja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CardPurposes")
public class CardPurpose extends BaseEntity{

    @NotNull
    @Column(unique = true)
    protected String purpose;
    
}
