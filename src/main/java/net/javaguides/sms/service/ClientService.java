package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Client;

public interface ClientService {
	List<Client> getAllClients();
	
	Client saveClient(Client client);
	
	Client getClientById(Integer cod_cli);
	
	Client updateClient(Client client);
	
	void deleteClientById(Integer cod_cli);
}