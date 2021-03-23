package com.service.demo.repositories;

import com.service.demo.vo.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
