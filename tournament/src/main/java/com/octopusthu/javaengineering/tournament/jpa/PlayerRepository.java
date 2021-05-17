package com.octopusthu.javaengineering.tournament.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author octopusthu@gmail.com
 */
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

}
