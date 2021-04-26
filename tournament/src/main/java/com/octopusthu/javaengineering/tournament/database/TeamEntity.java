package com.octopusthu.javaengineering.tournament.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author octopusthu@gmail.com
 */
@Entity
@Table(name = "team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity {

    @Id
    @Column
    private Integer seq;

    @Column
    private String name;
}
