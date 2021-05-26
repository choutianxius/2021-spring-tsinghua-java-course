package com.choutianxius.javaengineering.libraryassistant.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author choutianxius@gmail.com
 */
@Entity
@Table(name = "assistant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssistantEntity {

    @Id
    @Column
    private Integer seq;

    @Column
    private String name;

    @Column
    private Integer rank;

    @Column
    private String phone;
}
