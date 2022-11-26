package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Livraison;

public interface LivraisonService {
	List<Livraison> getAllLivraisons();
	
	Livraison saveLivraison(Livraison livraison);
	
	Livraison getLivraisonById(Integer num_liv);
	
	Livraison updateLivraison(Livraison livraison);
	
	void deleteLivraisonById(Integer num_liv);
}