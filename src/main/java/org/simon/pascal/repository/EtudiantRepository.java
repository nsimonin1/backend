/**
 * 
 */
package org.simon.pascal.repository;

import org.simon.pascal.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author simon.pascal.ngos
 *
 */
@RestResource(path="etudiants",exported=true)
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	
	@Query("SELECT MAX(etudiant.matricule) FROM Etudiant etudiant ")
	String getLastMatricule();
	
	Etudiant findOneByMatricule(String matricule);
}
