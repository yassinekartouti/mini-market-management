package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.LigneLiv;

public interface LigneLivService {
	List<LigneLiv> getAllLigneLivs();
	
	LigneLiv saveLigneLiv(LigneLiv ligneLiv);
	
	LigneLiv getLigneLivById(Integer num_ligneliv);
	
	LigneLiv updateLigneLiv(LigneLiv ligneLiv);
	
	void deleteLigneLivById(Integer num_ligneliv);
}