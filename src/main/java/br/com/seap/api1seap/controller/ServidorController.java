package br.com.seap.api1seap.controller;

import br.com.seap.api1seap.controller.dto.ServidorDto;
import br.com.seap.api1seap.controller.form.PutServidorForm;
import br.com.seap.api1seap.controller.form.ServidorForm;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import br.com.seap.api1seap.usecase.CriarServidorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/servidor")
@RestController
public class ServidorController {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private CriarServidorUseCase criarServidorUseCase;

    @GetMapping
    public List<ServidorDto> getAll(){
        List<Servidor> listServidor = servidorRepository.findAll();
        return ServidorDto.converterList(listServidor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorDto> getById(@PathVariable Long id){
        Optional<Servidor> servidor = servidorRepository.findById(id);

        return servidor.map(value -> ResponseEntity.ok(new ServidorDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional //Toda modificacao precisa
    public ResponseEntity<ServidorDto> post(@RequestBody ServidorForm servidorForm, UriComponentsBuilder uriBuilder){
        Servidor servidor = servidorForm.converter();

        criarServidorUseCase.executar(servidor);

        servidor.getListCargos().forEach(a -> System.out.println(a.getDescricao()));

        URI uri = uriBuilder.path("/servidor/{id}").buildAndExpand(servidor.getId()).toUri(); //Created resource address
        return ResponseEntity.created(uri).body(new ServidorDto(servidor));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ServidorDto> put(@PathVariable Long id, @RequestBody PutServidorForm putServidorForm){
        Optional<Servidor> servidor = servidorRepository.findById(id);

        return servidor.map
                (value -> ResponseEntity.ok
                        (new ServidorDto(putServidorForm.atualiza(id, servidorRepository))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Servidor> servidor = servidorRepository.findById(id);

        return servidor.map(value -> {
            servidorRepository.deleteById(id);
            return ResponseEntity.ok().build();
            }
            ).orElseGet(() -> ResponseEntity.notFound().build());
    }
/*
    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    } */


}
