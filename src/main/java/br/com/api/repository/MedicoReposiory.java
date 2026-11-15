package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.Medico;

@Repository 
public interface MedicoReposiory extends JpaRepository<Medico, Long> {

}
