package edu.mum.cs.cs425.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.model.ClassRoom;
import edu.mum.cs.cs425.repository.ClassRoomRepository;
import edu.mum.cs.cs425.service.ClassRoomService;


@Service
public class ClassRoomImpl implements ClassRoomService {
	
	@Autowired
	ClassRoomRepository classroomRepository;

	@Override
	public ClassRoom saveClassroom(ClassRoom classRoom) {
		return classroomRepository.save(classRoom);
	}

}
