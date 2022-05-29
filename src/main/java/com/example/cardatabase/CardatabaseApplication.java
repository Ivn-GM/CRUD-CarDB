package com.example.cardatabase;

import com.example.cardatabase.model.Car;
import com.example.cardatabase.model.Owner;
import com.example.cardatabase.repository.CarRepository;
import com.example.cardatabase.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	//private static final Logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	@Autowired
	private CarRepository carRepository;
	private Car car;

	@Autowired
	private OwnerRepository ownerRepository;
	private Owner owner;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("Steve", "Owens");
		Owner owner2 = new Owner("Felix", "Gomez");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));

		carRepository.save(new Car("Ford", "Focus", "Rojo", "ADF-1121", 2021, 59000, owner1));
		carRepository.save(new Car("Renault", "Megane", "Azul", "JHG-4561", 2019, 30000, owner2));
		carRepository.save(new Car("BMW", "Z4", "Negro", "FRT-1568", 2022, 65000, owner1));

		//System.out.println(carRepository.findByBrand("BMW"));
		//System.out.println(carRepository.findAllBrands());
		/*for (Car car : carRepository.findAll()) {
			System.out.println(car.getBrand() + " " + car.getModel());
		}*/
	}

}
