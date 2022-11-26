package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Fournisseur;
import net.javaguides.sms.repository.FournisseurRepository;
import net.javaguides.sms.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService{

	private FournisseurRepository fournisseurRepository;
	
	public FournisseurServiceImpl(	FournisseurRepository fournisseurRepository) {
		super();
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public List<Fournisseur> getAllFournisseurs() {
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public Fournisseur getFournisseurById(Integer cod_four) {
		return fournisseurRepository.findById(cod_four).get();
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public void deleteFournisseurById(Integer cod_four) {
		fournisseurRepository.deleteById(cod_four);	
	}

}
