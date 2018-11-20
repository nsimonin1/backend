/**
 * 
 */
package org.simon.pascal.controller;

import java.util.List;

import javax.validation.Valid;

import org.simon.pascal.dto.EtudiantMaj;
import org.simon.pascal.dto.EtudiantNew;
import org.simon.pascal.entities.Etudiant;
import org.simon.pascal.exception.BusinessResourceException;
import org.simon.pascal.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simon.pascal.ngos
 *
 */
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
	
	private final EtudiantService etudiantService;
	

	public EtudiantController(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}


	@GetMapping
	public ResponseEntity<List<Etudiant>> allEtudiant(){
		return ResponseEntity.ok(etudiantService.etudiants());
	}
	
	@PostMapping
	public ResponseEntity<Etudiant> create(@Valid @RequestBody EtudiantNew etudiant) {
		return ResponseEntity.ok(etudiantService.create(etudiant));
	}
	
	@PatchMapping("/maj/{matricule}")
	public ResponseEntity<String> create(@PathVariable String matricule
			,@RequestBody EtudiantMaj etudiant) throws BusinessResourceException {
		etudiantService.update(matricule, etudiant);
		return ResponseEntity.ok("OK");
	}
	
	@PostMapping("/del/{matricule}")
	public ResponseEntity<String> create(@PathVariable String matricule) throws BusinessResourceException {
		etudiantService.delete(matricule);
		return ResponseEntity.ok("OK");
	}
	
	
}
