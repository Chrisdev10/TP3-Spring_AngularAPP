package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsRepo extends JpaRepository<Subscription,Long> {
}
