package com.octopusthu.javaengineering.tournament.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
@Entity
@Table(name = "team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity {

    @Id
    @Column
    private Integer seq;

    @Column
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMemberEntity> members;

}
