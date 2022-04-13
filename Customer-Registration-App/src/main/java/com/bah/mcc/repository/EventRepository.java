package com.bah.mcc.repository;
import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
