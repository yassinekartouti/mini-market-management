package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Societe;

public interface SocieteService {
	List<Societe> getAllSocietes();
	
	Societe saveSociete(Societe societe);
	
	Societe getSocieteById(Integer cod_ste);
	
	Societe updateSociete(Societe societe);
	
	void deleteSocieteById(Integer cod_ste);
}