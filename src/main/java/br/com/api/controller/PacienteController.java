package br.com.api.controller;

import br.com.api.model.Paciente;
import br.com.api.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public Paciente listarporId(@PathVariable Long id) {
        return pacienteService.listarPorId(id);
    }

    @PostMapping
    public Paciente adicionarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.adicionarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.atualizarPaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletarpaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
    }

}
