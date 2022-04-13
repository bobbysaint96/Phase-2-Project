package com.bah.mcc.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.mcc.domain.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
