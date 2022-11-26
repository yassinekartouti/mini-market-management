package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Livraison;
import net.javaguides.sms.repository.LivraisonRepository;
import net.javaguides.sms.service.LivraisonService;

@Service
public class LivraisonServiceImpl implements LivraisonService{

	private LivraisonRepository livraisonRepository;
	
	public LivraisonServiceImpl(	LivraisonRepository livraisonRepository) {
		super();
		this.livraisonRepository = livraisonRepository;
	}

	@Override
	public List<Livraison> getAllLivraisons() {
		return livraisonRepository.findAll();
	}

	@Override
	public Livraison saveLivraison(Livraison livraison) {
		return livraisonRepository.save(livraison);
	}

	@Override
	public Livraison getLivraisonById(Integer num_liv) {
		return livraisonRepository.findById(num_liv).get();
	}

	@Override
	public Livraison updateLivraison(Livraison livraison) {
		return livraisonRepository.save(livraison);
	}

	@Override
	public void deleteLivraisonById(Integer num_liv) {
		livraisonRepository.deleteById(num_liv);	
	}

}
