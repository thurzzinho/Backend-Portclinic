package br.com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.api.model.Profissional;
import br.com.api.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    private final ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {

        this.profissionalRepository = profissionalRepository;
    }

    public List<Profissional> listar() {
        return profissionalRepository.findAll();
    }

    public Profissional listarPorId(Long id) {
        return profissionalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Profissioanl não encontrado com o id: " + id));
    }

    public Profissional adicionarProfissional(Profissional profissional) {
        if (profissionalRepository.existsByCrm(profissional.getCrm())) {
            throw new RuntimeException("Já existe um médico cadastrado com este CRM: " + profissional.getCrm());
        }
        return profissionalRepository.save(profissional);
    }

    public Profissional atualizarprofissional(Long id, Profissional profissional) {
        var medicoAtualizado = listarPorId(id);
        medicoAtualizado.setCrm(profissional.getCrm());
        medicoAtualizado.setNome(profissional.getNome());
        medicoAtualizado.setEspecialidade(profissional.getEspecialidade());
        medicoAtualizado.setTelefone(profissional.getTelefone());

        return profissionalRepository.save(medicoAtualizado);

    }

    public void deletarProfissional(Long id) {
        var medico = listarPorId(id);
        profissionalRepository.delete(medico);
    }
}
