package edu.mum.cs.cs425.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.model.Transcript;
import edu.mum.cs.cs425.repository.TranscriptRepository;


@Service
public class TranscriptService implements edu.mum.cs.cs425.service.TranscriptService {
	
	@Autowired
	TranscriptRepository transcriptRepository;

	@Override
	public Transcript saveTranscript(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

}
