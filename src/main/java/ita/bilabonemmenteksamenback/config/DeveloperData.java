package ita.bilabonemmenteksamenback.config;

import ita.bilabonemmenteksamenback.entity.Car;
import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.repository.CarRepository;
import ita.bilabonemmenteksamenback.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

  /* private final CustomerRepository customerRepository;

    public DeveloperData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //dummy car list
    public static List<Customer> Customers = Arrays.asList(
            new Customer("Mads Jensen", "mads.jensen@gmail.com", "12345", "Funkevænget 21", "1906", true),
            new Customer("Signe Nielsen", "signe.nielsen@gmail.com", "67890", "Espegyden 68", "9320", false),
            new Customer("Anders Larsen", "anders.larsen@gmail.com", "13579", "Sveltekrogen 5", "1558", true),
            new Customer("Lise Christensen", "lise.christensen@gmail.com", "24680", "Strandalléen 76", "8462", false),
            new Customer("Erik Mortensen", "erik.mortensen@gmail.com", "97531", "Sludevej 45", "1360", true),
            new Customer("Anne Olsen", "anne.olsen@gmail.com", "86420", "Lodskovvej 99", "1857", false),
            new Customer("Peter Pedersen", "peter.pedersen@gmail.com", "15937", "Hovbanken 31", "6980", true),
            new Customer("Maria Andreasen", "maria.andreasen@gmail.com", "35791", "Holmevej 13", "1427", false),
            new Customer("Jørgen Møller", "jorgen.moller@gmail.com", "46825", "Øksendrupvej 20", "1320", true),
            new Customer("Louise Rasmussen", "louise.rasmussen@gmail.com", "90210", "Bramstrup 99", "1003", false)
    );*/
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Controller Started");
       /*customerRepository.saveAll(Customers);*/
    }
}
