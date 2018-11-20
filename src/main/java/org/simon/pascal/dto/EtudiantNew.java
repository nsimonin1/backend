/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.pascal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author simon.pascal.ngos
 */
public class EtudiantNew implements Serializable { 

    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    private String nomPrenom; 
    @NotEmpty
    private String sexe;
    @NotEmpty
    private String age;
	/**
	 * @return the nomPrenom
	 */
	public String getNomPrenom() {
		return nomPrenom;
	}
	/**
	 * @param nomPrenom the nomPrenom to set
	 */
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

    
    
}
