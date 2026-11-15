package br.com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.api.model.Medico;
import br.com.api.repository.MedicoReposiory;

@Service
public class MedicoService {
	private final MedicoReposiory medicoRepository;

	public MedicoService(MedicoReposiory medicoRepository) {

		this.medicoRepository = medicoRepository;
	}
	
	public List<Medico> listar(){
		return medicoRepository.findAll();
	}
	
	public Medico listarPorId(Long id) {
		return medicoRepository.findById(id).get();
	}
	
	public Medico adicionarMedico(Medico medico) {
		return medicoRepository.save(medico);
	}
	
	public Medico atualizarMedico(Long id, Medico medico) {
		var medicoAtualizado = listarPorId(id);
		medicoAtualizado.setCrm(medico.getCrm());
		medicoAtualizado.setNome(medico.getNome());
		medicoAtualizado.setEspecialidade(medico.getEspecialidade());
		medicoAtualizado.setTelefone(medico.getTelefone());
		medicoAtualizado.setId(medico.getId());
		return medicoRepository.save(medicoAtualizado);
		
	}
	
	public void deletarMedico(Long id) {
		medicoRepository.deleteById(id);
	}
}
