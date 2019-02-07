package vpo.angularskill.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vpo.angularskill.entities.EtatCivil;

public interface EtatCivilRepository extends JpaRepository<EtatCivil, Long> {

	@Query("select etc from EtatCivil etc where etc.nom like :x")
	public Page<EtatCivil> chercherEC(@Param("x") String motCle, Pageable pageable);

	@Query("select etc from EtatCivil etc")
	public Page<EtatCivil> getEtCivils(Pageable pageable);
}
