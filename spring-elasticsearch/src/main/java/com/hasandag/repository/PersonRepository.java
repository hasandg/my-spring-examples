package com.hasandag.repository;

import com.hasandag.entitiy.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);

    List<Person> getByNameLikeOrLastNameLike(String name, String lastName);

}
