package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Client;
import net.javaguides.sms.repository.ClientRepository;
import net.javaguides.sms.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
@Autowired
	private ClientRepository clientRepository;
	
	public ClientServiceImpl(	ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client getClientById(Integer cod_cli) {
		return clientRepository.findById(cod_cli).get();
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteClientById(Integer cod_cli) {
		clientRepository.deleteById(cod_cli);	
	}

}
