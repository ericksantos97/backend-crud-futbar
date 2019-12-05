package br.com.project.futbarproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {

    Long id;
    String initials;
    String name;
    String descriptionConstruction;
    String descriptionEquipment;
    String descriptionMembership;
    String descriptionRegion;

}
