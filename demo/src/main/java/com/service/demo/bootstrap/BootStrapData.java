package com.service.demo.bootstrap;

import com.service.demo.repositories.CustomerRepository;
import com.service.demo.repositories.TimeSlotRepository;
import com.service.demo.repositories.VehicleRepository;
import com.service.demo.vo.TimeSlot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final TimeSlotRepository timeSlotRepository;

    private final VehicleRepository vehicleRepository;

    public BootStrapData(CustomerRepository customerRepository, TimeSlotRepository timeSlotRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        TimeSlot timeSlot1 = new TimeSlot("9:00-10:00");
        TimeSlot timeSlot2 = new TimeSlot("10:00-11:00");
        TimeSlot timeSlot3 = new TimeSlot("11:00-12:00");
        TimeSlot timeSlot4 = new TimeSlot("12:00-13:00");
        TimeSlot timeSlot5 = new TimeSlot("13:00-14:00");
        TimeSlot timeSlot6 = new TimeSlot("15:00-16:00");
        TimeSlot timeSlot7 = new TimeSlot("17:00-18:00");
        TimeSlot timeSlot8 = new TimeSlot("19:00-20:00");
        TimeSlot timeSlot9 = new TimeSlot("20:00-21:00");
        timeSlotRepository.save(timeSlot1);
        timeSlotRepository.save(timeSlot2);
        timeSlotRepository.save(timeSlot3);
        timeSlotRepository.save(timeSlot4);
        timeSlotRepository.save(timeSlot5);
        timeSlotRepository.save(timeSlot6);
        timeSlotRepository.save(timeSlot7);
        timeSlotRepository.save(timeSlot8);
        timeSlotRepository.save(timeSlot9);
        System.out.println("Total Time Slots" + timeSlotRepository.count());
    }
}
