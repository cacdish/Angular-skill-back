package vpo.angularskill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vpo.angularskill.dao.EtatCivilRepository;
import vpo.angularskill.entities.EtatCivil;

@SpringBootApplication
public class AngularSkillApplication implements CommandLineRunner {

	@Autowired
	private EtatCivilRepository etatCivilRepository;

	public static void main(String[] args) {
		SpringApplication.run(AngularSkillApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		etatCivilRepository.save(new EtatCivil("Carbone", "Matéo", "06798278", "jcesar@gmail.com"));
		etatCivilRepository.save(new EtatCivil("La Margère", "Pisse", "06798278", "jcesar@gmail.com"));
		etatCivilRepository.save(new EtatCivil("Parteneau", "François", "06798278", "jcesar@gmail.com"));
		etatCivilRepository.save(new EtatCivil("Kasserole", "Vénise", "06798278", "jcesar@gmail.com"));

		System.out.println("---------------------------");
		etatCivilRepository.findAll().forEach(etc -> {
			System.out.println(etc.getId() + ",\n" + etc.getPrenom() + ", " + etc.getNom() + ",\ntél. : "
					+ etc.getTelephone() + ",\nEmail : " + etc.getEmail() + "\n---------------------------");
		});

	}

}
