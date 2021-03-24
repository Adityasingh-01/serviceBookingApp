package com.service.demo.controllers;

import com.service.demo.repositories.CustomerRepository;
import com.service.demo.repositories.VehicleRepository;
import com.service.demo.vo.Bike;
import com.service.demo.vo.Car;
import com.service.demo.vo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceController {

    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;

    public ServiceController(CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/home")
    public String main(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("errorCode", "01");
        } else {
            Customer customer = getCustomerByEmail(email);
            if(customer == null) {
                model.addAttribute("errorMessage", "You need to login or register");
                model.addAttribute("errorCode", "01");
            } else {
                model.addAttribute("customer", customer);
            }
        }

        return "index"; //view
    }

    @GetMapping("/register")
    public String registration(Model model, HttpServletRequest request) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");


        return "registration"; //view
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");


        return "login"; //view
    }
    @GetMapping("/logOut")
    public String logOut(Model model, HttpServletRequest request, HttpServletResponse response) {
        addCookieToResponse("bs_email", "", response);
        model.addAttribute("errorMessage", "You need to login or register");
        model.addAttribute("errorCode", "01");

        return "welcome"; //view
    }

    @GetMapping("/handleRegistration")
    public String handleRegistration(Model model, HttpServletRequest request, HttpServletResponse response) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumberStr = request.getParameter("number");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        if(!StringUtils.isEmpty(phoneNumberStr) && !StringUtils.isEmpty(email)) {
            Customer customer = new Customer(firstName, lastName, null, null, address, email, phoneNumberStr, null);
            customer.setPassword(password);
            model.addAttribute("customer", customer);
            customerRepository.save(customer);
            addCookieToResponse("bs_email", email, response);
            return "welcome"; //view
        } else {
            model.addAttribute("errorMessage", "Please provide a valid phone/email");
            model.addAttribute("errorCode", "01");

            return "registration"; //view
        }
    }

    @GetMapping("/handleLogin")
    public String handleLogin(Model model, HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(!StringUtils.isEmpty(email) && !StringUtils.isEmpty(password)) {
            Customer customer = getCustomerByEmail(email);
            if(customer == null) {
                model.addAttribute("errorMessage", "Please provide a valid email/password");
                model.addAttribute("errorCode", "01");
            } else if(customer.getPassword().equals(password)) {
                model.addAttribute("customer", customer);
            } else {

            }
        } else {
            model.addAttribute("errorMessage", "Please provide a valid email/password");
            model.addAttribute("errorCode", "01");
        }
        return "welcome"; //view
    }

    @GetMapping("/welcome")
    public String accountPage(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("errorMessage", "You need to login or register");
            model.addAttribute("errorCode", "01");
        } else {
            Customer customer = getCustomerByEmail(email);
            if(customer == null) {
                model.addAttribute("errorMessage", "You need to login or register");
                model.addAttribute("errorCode", "01");
            } else {
                model.addAttribute("customer", customer);
            }
        }

        return "welcome"; //view
    }

    @GetMapping("/addCar")
    public String addCar(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("errorMessage", "You need to login or register");
            model.addAttribute("errorCode", "01");
            return "welcome";
        } else {
            Customer customer = getCustomerByEmail(email);
            if(customer == null) {
                model.addAttribute("errorMessage", "You need to login or register");
                model.addAttribute("errorCode", "01");
                return "welcome";
            } else {
                model.addAttribute("customer", customer);
                return "addCar";
            }
        }
    }

    @GetMapping("/addBike")
    public String addBike(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("errorMessage", "You need to login or register");
            model.addAttribute("errorCode", "01");
            return "welcome";
        } else {
            Customer customer = getCustomerByEmail(email);
            if(customer == null) {
                model.addAttribute("errorMessage", "You need to login or register");
                model.addAttribute("errorCode", "01");
                return "welcome";
            } else {
                model.addAttribute("customer", customer);
                return "addBike";
            }
        }
    }

    @GetMapping("/handleAddCar")
    public String handleAddCar(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("errorCode", "01");
            model.addAttribute("errorMessage", "You need to login or register");
        } else {
            Customer customer = getCustomerByEmail(email);
            if(customer != null) {
                String thisModel = request.getParameter("model");
                String variant = request.getParameter("variant");
                String type = request.getParameter("variant");
                String power = request.getParameter("power");
                String weight = request.getParameter("weight");
                String services = request.getParameter("services");
                int servicesInt = Integer.parseInt(services);
                String registrationNo = request.getParameter("registrationNo");
                int registrationNOInt = Integer.parseInt(registrationNo);
                String insurance = request.getParameter("insurance");
                boolean isInsurance = Boolean.parseBoolean(insurance);
                String seats = request.getParameter("seats");
                int seatsInt = Integer.parseInt(seats);
                String doors = request.getParameter("doors");
                int doorsInt = Integer.parseInt(doors);
                if (registrationNo != null) {
                    Car car = new Car();
                    car.setVariant(variant);
                    car.setModel(thisModel);
                    car.setType(type);
                    car.setPower(power);
                    car.setWeight(weight);
                    car.setServices(servicesInt);
                    car.setRegistrationNo(registrationNOInt);
                    car.setInsurance(isInsurance);
                    car.setDoors(doorsInt);
                    List<Car> cars = customer.getCars();
                    if (cars == null) {
                        cars = new ArrayList<>();
                        cars.add(car);
                        customer.setCars(cars);
                        vehicleRepository.save(car);
                        customerRepository.save(customer);
                    }
                }
            } else {
                model.addAttribute("errorCode", "01");
                model.addAttribute("errorMessage", "You need to login or register");
            }
        }
        return "welcome";
    }

    @GetMapping("/handleAddBike")
    public String handleAddBike(Model model, HttpServletRequest request) {
        String email=readCookie("bs_email", request);
        if(StringUtils.isEmpty(email)) {
            model.addAttribute("message", "message");
            model.addAttribute("tasks", "tasks");
        }
        else {
            Customer customer = getCustomerByEmail(email);
            if (customer != null) {

                String bikeModel = request.getParameter("model");
                String variant = request.getParameter("variant");
                String type = request.getParameter("type");
                String power = request.getParameter("power");
                String weight = request.getParameter("weight");
                String serviceNo = request.getParameter("serviceNo");
                int serviceNoInt = Integer.parseInt(serviceNo);
                String registrationNo = request.getParameter("registrationNo");
                int registrationNoInt = Integer.parseInt(registrationNo);
                String insurance = request.getParameter("insurance");
                boolean isInsurance = Boolean.parseBoolean(insurance);
                String superBike = request.getParameter("type");
                String suspension = request.getParameter("suspension");
                String braking = request.getParameter("braking");


                if (registrationNo != null) {
                    Bike bike = new Bike();
                    bike.setModel(bikeModel);
                    bike.setVariant(variant);
                    bike.setType(type);
                    bike.setPower(power);
                    bike.setWeight(weight);
                    bike.setServices(serviceNoInt);
                    bike.setRegistrationNo(registrationNoInt);
                    bike.setInsurance(isInsurance);
                    bike.setType(superBike);
                    bike.setSuspension(suspension);
                    bike.setBraking(braking);
                    List<Bike> bikes = customer.getBikes();
                    if (bikes == null) {
                        bikes = new ArrayList<>();
                        bikes.add(bike);
                        customer.setBikes(bikes);
                        vehicleRepository.save(bike);
                        customerRepository.save(customer);
                    }
                }
            }
            else {
                model.addAttribute("errorCode", "01");
                model.addAttribute("errorMessage", "You need to login or register");
            }
        }


        return "welcome";
    }

    private void addCookieToResponse(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    private String readCookie(String name, HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, name);
        if(cookie != null && !StringUtils.isEmpty(cookie.getValue())) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    private Customer getCustomerByEmail(String email) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        if(customers != null && !customers.isEmpty()) {
            for(Customer customer : customers) {
                if(customer.getEmailId().equalsIgnoreCase(email)) {
                    return customer;
                }
            }
        }
        return null;
    }



}
