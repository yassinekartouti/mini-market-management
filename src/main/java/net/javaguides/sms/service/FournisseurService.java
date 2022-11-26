package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Fournisseur;

public interface FournisseurService {
	List<Fournisseur> getAllFournisseurs();
	
	Fournisseur saveFournisseur(Fournisseur fournisseur);
	
	Fournisseur getFournisseurById(Integer cod_four);
	
	Fournisseur updateFournisseur(Fournisseur fournisseur);
	
	void deleteFournisseurById(Integer cod_four);
}