package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Commande;

public interface CommandeService {
	List<Commande> getAllCommandes();
	
	Commande saveCommande(Commande commande);
	
	Commande getCommandeById(Integer num_cmd);
	
	Commande updateCommande(Commande commande);
	
	void deleteCommandeById(Integer num_cmd);
}