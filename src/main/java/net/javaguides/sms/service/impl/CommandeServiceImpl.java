package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Commande;
import net.javaguides.sms.repository.CommandeRepository;
import net.javaguides.sms.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{

	private CommandeRepository commandeRepository;
	
	public CommandeServiceImpl(	CommandeRepository commandeRepository) {
		super();
		this.commandeRepository = commandeRepository;
	}

	@Override
	public List<Commande> getAllCommandes() {
		return commandeRepository.findAll();
	}

	@Override
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public Commande getCommandeById(Integer num_cmd) {
		return commandeRepository.findById(num_cmd).get();
	}

	@Override
	public Commande updateCommande(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public void deleteCommandeById(Integer num_cmd) {
		commandeRepository.deleteById(num_cmd);	
	}

}
