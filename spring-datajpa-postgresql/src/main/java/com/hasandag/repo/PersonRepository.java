package com.hasandag.repo;

import com.hasandag.entitiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Note: Normally a repo needs to be annotated with "@Repository" but if its extends a repo already
 * that's not necessary
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
