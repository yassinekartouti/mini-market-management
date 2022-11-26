package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.LigneCmd;
import net.javaguides.sms.repository.LigneCmdRepository;
import net.javaguides.sms.service.LigneCmdService;

@Service
public class LigneCmdServiceImpl implements LigneCmdService{

	private LigneCmdRepository ligneCmdRepository;
	
	public LigneCmdServiceImpl(	LigneCmdRepository ligneCmdRepository) {
		super();
		this.ligneCmdRepository = ligneCmdRepository;
	}

	@Override
	public List<LigneCmd> getAllLigneCmds() {
		return ligneCmdRepository.findAll();
	}

	@Override
	public LigneCmd saveLigneCmd(LigneCmd ligneCmd) {
		return ligneCmdRepository.save(ligneCmd);
	}

	@Override
	public LigneCmd getLigneCmdById(Integer num_ligne) {
		return ligneCmdRepository.findById(num_ligne).get();
	}

	@Override
	public LigneCmd updateLigneCmd(LigneCmd ligneCmd) {
		return ligneCmdRepository.save(ligneCmd);
	}

	@Override
	public void deleteLigneCmdById(Integer num_ligne) {
		ligneCmdRepository.deleteById(num_ligne);	
	}

}
