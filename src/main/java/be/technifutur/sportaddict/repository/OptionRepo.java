package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<Option, Long> {
}
