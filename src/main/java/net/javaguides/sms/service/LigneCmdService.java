package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.LigneCmd;

public interface LigneCmdService {
	List<LigneCmd> getAllLigneCmds();
	
	LigneCmd saveLigneCmd(LigneCmd ligneCmd);
	
	LigneCmd getLigneCmdById(Integer num_ligne);
	
	LigneCmd updateLigneCmd(LigneCmd ligneCmd);
	
	void deleteLigneCmdById(Integer num_ligne);
}