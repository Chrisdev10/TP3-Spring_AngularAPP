package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findClientByEmail(String email);
    @Query("select c from Client c where c.username = ?1")
    Client findClientByUsername(String username);
}
