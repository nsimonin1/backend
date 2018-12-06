/**
 * 
 */
package org.simon.pascal.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.simon.pascal.dto.EtudiantMaj;
import org.simon.pascal.dto.EtudiantNew;
import org.simon.pascal.entities.Etudiant;
import org.simon.pascal.exception.BusinessResourceException;
import org.simon.pascal.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author simon.pascal.ngos
 *
 */
public class EtudiantControllerTest {

	@Rule
	public MockitoRule mockitoRole = MockitoJUnit.rule();
	@Mock
	private EtudiantService etudiantService;
	private EtudiantController controller;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		controller=new EtudiantController(etudiantService);
	}

	/**
	 * Test method for {@link org.simon.pascal.controller.EtudiantController#allEtudiant()}.
	 */
	@Test
	public void testAllEtudiant() {
		when(etudiantService.etudiants()).thenReturn(new ArrayList<>());
		ResponseEntity<List<Etudiant>> result=controller.allEtudiant();
		assertThat(result, IsNull.notNullValue());
		assertThat(result.getStatusCode(), IsEqual.equalTo(HttpStatus.OK));
		verify(etudiantService).etudiants();
	}

	/**
	 * Test method for {@link org.simon.pascal.controller.EtudiantController#create(org.simon.pascal.dto.EtudiantNew)}.
	 */
	@Test
	public void testCreateEtudiantNew() {		
		EtudiantNew etudiant=new EtudiantNew();
		when(etudiantService.create(etudiant)).thenReturn(new Etudiant());
		ResponseEntity<Etudiant> result=controller.create(etudiant);
		assertThat(result, IsNull.notNullValue());
		assertThat(result.getStatusCode(), IsEqual.equalTo(HttpStatus.OK));
		verify(etudiantService).create(etudiant);
	}

	/**
	 * Test method for {@link org.simon.pascal.controller.EtudiantController#create(java.lang.String, org.simon.pascal.dto.EtudiantMaj)}.
	 * @throws BusinessResourceException 
	 */
	@Test
	public void testMaj() throws BusinessResourceException {
		String matricule="";
		EtudiantMaj etudiant=new EtudiantMaj();
		doNothing().when(etudiantService).update(matricule, etudiant);
		ResponseEntity<String> result=controller.maj(matricule, etudiant);
		assertThat(result, IsNull.notNullValue());
		assertThat(result.getStatusCode(), IsEqual.equalTo(HttpStatus.OK));
		verify(etudiantService).update(matricule, etudiant);
	}

	/**
	 * Test method for {@link org.simon.pascal.controller.EtudiantController#create(java.lang.String)}.
	 * @throws BusinessResourceException 
	 */
	@Test
	public void testCreateString() throws BusinessResourceException {
		String matricule=""; 
		doNothing().when(etudiantService).delete(matricule);
		ResponseEntity<String> result=controller.supprimer(matricule);
		assertThat(result, IsNull.notNullValue());
		assertThat(result.getStatusCode(), IsEqual.equalTo(HttpStatus.OK));
		verify(etudiantService).delete(matricule);
	}

}
