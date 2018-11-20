/**
 * 
 */
package org.simon.pascal.repository;

import org.simon.pascal.entities.Etudiant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author simon.pascal.ngos
 *
 */
@RepositoryRestResource(path = "etudiants")
public interface EtudiantRepository extends PagingAndSortingRepository<Etudiant, Long>{

}
