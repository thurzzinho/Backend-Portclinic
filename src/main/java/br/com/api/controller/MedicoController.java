package br.com.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.model.Medico;
import br.com.api.service.MedicoService;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.listar();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return medicoService.listarPorId(id);
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody Medico medico) {
        return medicoService.adicionarMedico(medico);
    }

    @PutMapping("/{id}")
    public Medico atualizarMedico(@RequestBody Medico medico, @PathVariable Long id) {
        return medicoService.atualizarMedico(id, medico);
    }

    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
    }


}
