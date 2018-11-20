/**
 * 
 */
package org.simon.pascal.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.simon.pascal.dto.EtudiantMaj;
import org.simon.pascal.dto.EtudiantNew;
import org.simon.pascal.entities.Etudiant;
import org.simon.pascal.exception.BusinessResourceException;
import org.simon.pascal.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

/**
 * @author simon.pascal.ngos
 *
 */
@Service
@Transactional(readOnly=true)
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	public List<Etudiant> etudiants(){
		return etudiantRepository.findAll();
	}
	
	@Transactional
	public Etudiant create(EtudiantNew etudiant) {
		Etudiant entity=new Etudiant();
		entity.setAge(etudiant.getAge());
		entity.setNomPrenom(etudiant.getNomPrenom());
		entity.setSexe(etudiant.getSexe());
		String matricule = this.etudiantRepository.getLastMatricule();
		if (Objects.isNull(matricule)) {
			matricule = "00001";
		} else {
			final Integer ordre = Integer.valueOf(matricule) + 1;
			matricule = Strings.padStart(ordre.toString(), 5, '0');
		}
		entity.setMatricule(matricule);
		return etudiantRepository.save(entity);
	}
	
	/**
	 * 
	 * @param matricule
	 * @param etudiant
	 * @throws BusinessResourceException
	 */
	@Transactional
	public void update(String matricule,EtudiantMaj etudiant) throws BusinessResourceException {
		Optional<Etudiant> data=etudiantRepository.findOneByMatricule(matricule);
		if(data.isPresent()) {
			throw new BusinessResourceException("Cet Etudiant n'existe pas ["+matricule+"]");
		}
		Etudiant entity=data.get();
		if(Objects.nonNull(etudiant.getAge())) {
			entity.setAge(etudiant.getAge());
		}
		if(Objects.nonNull(etudiant.getNomPrenom())) {
			entity.setNomPrenom(etudiant.getNomPrenom());
		}
		
		if(Objects.nonNull(etudiant.getSexe())) {
			entity.setSexe(etudiant.getSexe()); 
		}
		
		etudiantRepository.save(entity);
		
	}
	
	@Transactional
	public void delete(String matricule) throws BusinessResourceException {
		Optional<Etudiant> data=etudiantRepository.findOneByMatricule(matricule);
		if(data.isPresent()) {
			throw new BusinessResourceException("Cet Etudiant n'existe pas ["+matricule+"]");
		}
		Etudiant entity=data.get(); 
		etudiantRepository.delete(entity);
	}
}
