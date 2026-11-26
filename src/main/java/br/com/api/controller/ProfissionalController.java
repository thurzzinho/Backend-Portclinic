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
import br.com.api.model.Profissional;
import br.com.api.service.ProfissionalService;


@RestController
@RequestMapping("/profissional")
public class ProfissionalController {
    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public List<Profissional> listarProfissionais() {
        return profissionalService.listar();
    }

    @GetMapping("/{id}")
    public Profissional buscarPorId(@PathVariable Long id) {
        return profissionalService.listarPorId(id);
    }

    @PostMapping
    public Profissional cadastrarProfissional(@RequestBody Profissional profissional) {
        return profissionalService.adicionarProfissional(profissional);
    }

    @PutMapping("/{id}")
    public Profissional atualizarProfissional(@RequestBody Profissional profissional, @PathVariable Long id) {
        return profissionalService.atualizarprofissional(id, profissional);
    }

    @DeleteMapping("/{id}")
    public void deletarProfissional(@PathVariable Long id) {
        profissionalService.deletarProfissional(id);
    }
}
