package vpo.angularskill.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vpo.angularskill.dao.EtatCivilRepository;
import vpo.angularskill.entities.EtatCivil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@CrossOrigin(origins = "**")
public class EtatCivilService {

	@Autowired
	private EtatCivilRepository etatCivilRepository;

	@RequestMapping(value = "/etatsCivils", method = RequestMethod.GET)
	public Page<EtatCivil> getEtatCivils(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		System.out.println("==> pageable " + pageable);
		return etatCivilRepository.getEtCivils(pageable);
//		return etatCivilRepository.findAll();
	}

	@RequestMapping(value = "/etatsCivils/{id}", method = RequestMethod.GET)
	public EtatCivil getEtatCivil(@PathVariable Long id) {
		return etatCivilRepository.getOne(id);
	}

	@RequestMapping(value = "/chercherEtatsCivils", method = RequestMethod.GET)
	public Page<EtatCivil> chercherEtatsCivils(@RequestParam(name = "motCle", defaultValue = "") String motCle,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		System.out.println("==> pageable " + pageable);
		return etatCivilRepository.chercherEC("%" + motCle + "%", pageable);
	}

	@RequestMapping(value = "/etatsCivils", method = RequestMethod.POST)
	public EtatCivil save(@RequestBody EtatCivil etatCivil) {
		return etatCivilRepository.save(etatCivil);
	}

	@RequestMapping(value = "/etatsCivils", method = RequestMethod.PUT)
	public EtatCivil saveByUpdate(@RequestBody EtatCivil etatCivil) {
		return etatCivilRepository.save(etatCivil);
	}

	@RequestMapping(value = "/etatsCivils", method = RequestMethod.DELETE)
	public EtatCivil deleteEtatCivil(@RequestBody EtatCivil etatCivil) {
		return etatCivilRepository.save(etatCivil);
	}

	@RequestMapping(value = "/etatsCivils/{id}", method = RequestMethod.DELETE)
	public boolean deleteById(@PathVariable Long id) {
		etatCivilRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value = "/etatsCivils/{id}", method = RequestMethod.PUT)
	public EtatCivil updateWithId(@PathVariable Long id, @RequestBody EtatCivil etatCivil) {
		etatCivil.setId(id);
		return etatCivilRepository.save(etatCivil);
	}

//	@RequestMapping(value = "/etatsCivils", method = RequestMethod.PUT)
//	public EtatCivil updateEtatCivil(@RequestBody EtatCivil etatCivil) {
//		return etatCivilRepository.saveAndFlush(etatCivil);
//	}

}
