package AWBD.HealthSched;

import AWBD.HealthSched.model.Pacient;
import AWBD.HealthSched.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HealthSchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSchedApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(PacientRepository pacientRepository) {
		return args -> {
			/*Pacient pacient = new Pacient();
			pacient.setNume("Popescu");
			pacient.setPrenume("Ion");
			pacient.setEmail("ion.popescu@email.com");
			pacient.setTelefon("0712345678");
			pacient.setCnp("1234567890123");
			pacient.setDataNasterii(LocalDate.of(1990, 5, 20));

			pacientRepository.save(pacient);

			System.out.println("Pacient salvat cu ID: " + pacient.getId());*/
		};
	}
}
