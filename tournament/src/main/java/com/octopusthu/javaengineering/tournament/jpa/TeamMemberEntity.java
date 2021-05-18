package com.octopusthu.javaengineering.tournament.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author octopusthu@gmail.com
 */
@Entity
@Table(name = "team_member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer seq;

    @ManyToOne
    @JoinColumn(name = "team")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "player")
    private PlayerEntity player;

    @Column(name = "squad_number")
    private Integer squadNumber;

    @Column(name = "is_captain")
    private Boolean captain;

}
