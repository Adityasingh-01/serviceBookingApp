package com.service.demo.repositories;

import com.service.demo.vo.TimeSlot;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
}
