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
        model.addAttribute("noVehicle", "true");

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
            boolean vehicleFound = false;
            if(customer.getCars() != null && !customer.getCars().isEmpty()) {
                vehicleFound = true;
            }
            if(customer.getBikes() != null && !customer.getBikes().isEmpty()) {
                vehicleFound = true;
            }
            if(!vehicleFound) {
                model.addAttribute("noVehicle", "true");
            }
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
                model.addAttribute("noVehicle", "true");
            } else if(customer.getPassword().equals(password)) {
                model.addAttribute("customer", customer);
                Car carSelected = new Car();
                model.addAttribute("carSelected", carSelected);
                boolean vehicleFound = false;
                if(customer.getCars() != null && !customer.getCars().isEmpty()) {
                    vehicleFound = true;
                }
                if(customer.getBikes() != null && !customer.getBikes().isEmpty()) {
                    vehicleFound = true;
                }
                if(!vehicleFound) {
                    model.addAttribute("noVehicle", "true");
                }
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
                boolean vehicleFound = false;
                if(customer.getCars() != null && !customer.getCars().isEmpty()) {
                    vehicleFound = true;
                }
                if(customer.getBikes() != null && !customer.getBikes().isEmpty()) {
                    vehicleFound = true;
                }
                if(!vehicleFound) {
                    model.addAttribute("noVehicle", "true");
                }
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
                String manufacturer = request.getParameter("manufacturer");
                String modelName = request.getParameter("modelName");
                String nickName = request.getParameter("nickName");
                String registrationNo = request.getParameter("registrationNo");
                String insurance = request.getParameter("insurance");
                boolean isInsurance = Boolean.parseBoolean(insurance);
                if (registrationNo != null) {
                    Car car = new Car();
                    car.setManufacturer(manufacturer);
                    car.setModelName(modelName);
                    car.setNickName(nickName);
                    car.setRegistrationNo(registrationNo);
                    car.setInsurance(isInsurance);
                    car.setOwner(customer);
                    List<Car> cars = customer.getCars();
                    if (cars == null) {
                        cars = new ArrayList<>();
                    }
                    cars.add(car);
                    customer.setCars(cars);
                    vehicleRepository.save(car);
                    customerRepository.save(customer);
                    model.addAttribute("customer", customer);
                }
            } else {
                model.addAttribute("errorCode", "01");
                model.addAttribute("errorMessage", "You need to login or register");
            }
        }
        return "welcome";
    }

    @GetMapping("/bookService")
    public String bookService(Model model, HttpServletRequest request) {
        String email = readCookie("bs_email", request);
        if (StringUtils.isEmpty(email)) {
            model.addAttribute("errorCode", "01");
            model.addAttribute("errorMessage", "You need to login or register");
        } else {
            Customer customer = getCustomerByEmail(email);
            if (customer != null) {
                model.addAttribute("customer", customer);
                boolean vehicleFound = false;
                if(customer.getCars() != null && !customer.getCars().isEmpty()) {
                    vehicleFound = true;
                }
                if(customer.getBikes() != null && !customer.getBikes().isEmpty()) {
                    vehicleFound = true;
                }
                if(!vehicleFound) {
                    model.addAttribute("noVehicle", "true");
                }
            } else {
                model.addAttribute("errorCode", "01");
                model.addAttribute("errorMessage", "You need to login or register");
            }
        }
        return "bookService";
    }

    @GetMapping("/fetchTimeSlots")
    public String fetchTimeSlots(Model model, HttpServletRequest request) {
        String carId = request.getParameter("carId");
        String email = readCookie("bs_email", request);
        if (StringUtils.isEmpty(email)) {
            model.addAttribute("errorCode", "01");
            model.addAttribute("errorMessage", "You need to login or register");
        } else {
            Customer customer = getCustomerByEmail(email);
            if (customer != null) {
                
            }
        }
        return "bookService";
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
                String modelName = request.getParameter("modelName");
                String nickName = request.getParameter("nickName");
                String manufacturer = request.getParameter("manufacturer");
                String registrationNo = request.getParameter("registrationNo");
                String insurance = request.getParameter("insurance");
                boolean isInsurance = Boolean.parseBoolean(insurance);


                if (registrationNo != null) {
                    Bike bike = new Bike();
                    bike.setModelName(modelName);
                    bike.setNickName(nickName);
                    bike.setManufacturer(manufacturer);
                    bike.setInsurance(isInsurance);
                    bike.setOwner(customer);
                    bike.setRegistrationNo(registrationNo);
                    List<Bike> bikes = customer.getBikes();
                    if (bikes == null) {
                        bikes = new ArrayList<>();
                    }
                    bikes.add(bike);
                    customer.setBikes(bikes);
                    vehicleRepository.save(bike);
                    customerRepository.save(customer);
                    model.addAttribute("customer", customer);
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
