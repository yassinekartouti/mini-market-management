package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
