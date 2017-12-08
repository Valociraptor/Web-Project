package com.valociraptor.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.overflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {

}
