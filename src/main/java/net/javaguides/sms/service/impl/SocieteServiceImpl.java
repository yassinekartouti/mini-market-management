package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Societe;
import net.javaguides.sms.repository.SocieteRepository;
import net.javaguides.sms.service.SocieteService;

@Service
public class SocieteServiceImpl implements SocieteService{

	private SocieteRepository societeRepository;
	
	public SocieteServiceImpl(	SocieteRepository societeRepository) {
		super();
		this.societeRepository = societeRepository;
	}

	@Override
	public List<Societe> getAllSocietes() {
		return societeRepository.findAll();
	}

	@Override
	public Societe saveSociete(Societe societe) {
		return societeRepository.save(societe);
	}

	@Override
	public Societe getSocieteById(Integer cod_ste) {
		return societeRepository.findById(cod_ste).get();
	}

	@Override
	public Societe updateSociete(Societe societe) {
		return societeRepository.save(societe);
	}

	@Override
	public void deleteSocieteById(Integer cod_ste) {
		societeRepository.deleteById(cod_ste);	
	}

}
