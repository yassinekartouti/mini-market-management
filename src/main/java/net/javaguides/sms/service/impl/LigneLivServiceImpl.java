package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.LigneLiv;
import net.javaguides.sms.repository.LigneLivRepository;
import net.javaguides.sms.service.LigneLivService;

@Service
public class LigneLivServiceImpl implements LigneLivService{

	private LigneLivRepository ligneLivRepository;
	
	public LigneLivServiceImpl(	LigneLivRepository ligneLivRepository) {
		super();
		this.ligneLivRepository = ligneLivRepository;
	}

	@Override
	public List<LigneLiv> getAllLigneLivs() {
		return ligneLivRepository.findAll();
	}

	@Override
	public LigneLiv saveLigneLiv(LigneLiv ligneLiv) {
		return ligneLivRepository.save(ligneLiv);
	}

	@Override
	public LigneLiv getLigneLivById(Integer num_ligneliv) {
		return ligneLivRepository.findById(num_ligneliv).get();
	}

	@Override
	public LigneLiv updateLigneLiv(LigneLiv ligneLiv) {
		return ligneLivRepository.save(ligneLiv);
	}

	@Override
	public void deleteLigneLivById(Integer num_ligneliv) {
		ligneLivRepository.deleteById(num_ligneliv);	
	}

}
