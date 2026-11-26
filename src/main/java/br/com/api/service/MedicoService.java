package br.com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.api.model.Medico;
import br.com.api.repository.MedicoRepository;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {

        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    public Medico listarPorId(Long id) {
        return medicoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Médico não encontrado com o id: " + id));
    }

    public Medico adicionarMedico(Medico medico) {
        if (medicoRepository.existsByCrm(medico.getCrm())) {
            throw new RuntimeException("Já existe um médico cadastrado com este CRM: " + medico.getCrm());
        }
        return medicoRepository.save(medico);
    }

    public Medico atualizarMedico(Long id, Medico medico) {
        var medicoAtualizado = listarPorId(id);
        medicoAtualizado.setCrm(medico.getCrm());
        medicoAtualizado.setNome(medico.getNome());
        medicoAtualizado.setEspecialidade(medico.getEspecialidade());
        medicoAtualizado.setTelefone(medico.getTelefone());

        return medicoRepository.save(medicoAtualizado);

    }

    public void deletarMedico(Long id) {
        var medico = listarPorId(id);
        medicoRepository.delete(medico);
    }
}
