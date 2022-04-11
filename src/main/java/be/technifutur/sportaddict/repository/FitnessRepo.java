package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.FitnessHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FitnessRepo extends JpaRepository<FitnessHall, Long> {

    List<FitnessHall> findByOwner_Id(Long id);
}
