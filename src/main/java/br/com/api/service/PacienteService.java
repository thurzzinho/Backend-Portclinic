package br.com.api.service;


import br.com.api.model.Paciente;
import br.com.api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listar(){
        return
    pacienteRepository.findAll();
    }

    public Paciente listarPorId(Long id){
        // aqui é basicamente para: procure um paciente com o id. se encontrar, retorne. se não, avise que não foi encontrado
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado com o id: " + id));
    }

    public Paciente adicionarPaciente(Paciente paciente) {
        // 1- verificar se já existe algum paciente com esse CPF
        if (pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new
                    RuntimeException("Já existe um paciente cadastrado com o CPF: " + paciente.getCpf());
        }

        // 2- Se não existir, isso  vai salvar  no banco
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Long id, Paciente paciente) {

        // 1- busca pacientes existentes, se não existir é exceção
        Paciente pacienteExistente = listarPorId(id);

        // 2- atualiza os dados com as informações
        pacienteExistente.setNome(paciente.getNome());
        pacienteExistente.setCpf(paciente.getCpf());
        pacienteExistente.setTelefone(paciente.getTelefone());
        pacienteExistente.setEmail(paciente.getEmail());
        pacienteExistente.setDataNascimento(paciente.getDataNascimento());

        // agora, isso vai salvar os dados atualizados no banco
        return pacienteRepository.save(pacienteExistente);
    }

    //void aqui porque não vai retornar nada, só vai deletar 
    public void deletarPaciente(Long id) {
        Paciente paciente = listarPorId(id);
        pacienteRepository.delete(paciente);
    }
}
