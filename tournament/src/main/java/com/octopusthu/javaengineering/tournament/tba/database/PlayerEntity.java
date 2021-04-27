package com.octopusthu.javaengineering.tournament.tba.database;

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
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @Column
    private Integer seq;

    @Column
    private String name;
}
