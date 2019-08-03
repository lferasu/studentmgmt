package edu.mum.cs.cs425.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.model.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

}
