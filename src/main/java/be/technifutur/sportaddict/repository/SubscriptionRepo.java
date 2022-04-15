package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    @Query(value = "select s.client_id, s.fitness_id, s.contract_access, s.expire_date, s.contract_type from Subscription as s where client_id = ?1", nativeQuery = true)
    Optional<Subscription> findByClientID(Long id);
}
