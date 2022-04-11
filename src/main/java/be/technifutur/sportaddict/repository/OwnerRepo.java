package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Long> {

}
