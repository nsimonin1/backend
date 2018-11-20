/**
 * 
 */
package org.simon.pascal.repository;

import java.util.Optional;

import org.simon.pascal.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author simon.pascal.ngos
 *
 */
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	
	@Query("SELECT MAX(etudiant.matricule) FROM Etudiant etudiant ")
	String getLastMatricule();
	
	Optional<Etudiant> findOneByMatricule(String matricule);
}
