package br.com.seap.api1seap.controller;

import br.com.seap.api1seap.controller.request.AtualizaServidorRequest;
import br.com.seap.api1seap.controller.request.ServidorResquest;
import br.com.seap.api1seap.controller.response.ServidorResponse;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/servidor")
@RestController
public class ServidorController {

    @Autowired
    private CriarServidorUseCase criarServidorUseCase;

    @Autowired
    private BuscarTodosServidoresUseCase buscarTodosServidoresUseCase;

    @Autowired
    private BuscarServidoreUseCase buscarServidorUseCase;

    @Autowired
    private DeletarServidoreUseCase detelarServidorUseCase;

    @Autowired
    private AtualizarServidorUseCase atualizarServidorUseCase;

    @GetMapping
    public List<ServidorResponse> consultarTodos() {
        List<Servidor> servidores = buscarTodosServidoresUseCase.executar();
        return servidores.stream().map(ServidorResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorResponse> consultarPorId(@PathVariable Long id) {
        return buscarServidorUseCase.executar(id).map(value -> ResponseEntity.ok(new ServidorResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServidorResponse> criar(@RequestBody ServidorResquest servidorResquest, UriComponentsBuilder uriBuilder) {

        Servidor servidor = servidorResquest.converter();
        criarServidorUseCase.executar(servidor);

        URI uri = uriBuilder.path("/servidor/{id}").buildAndExpand(servidor.getId()).toUri(); //Created resource address
        return ResponseEntity.created(uri).body(new ServidorResponse(servidor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorResponse> atualizar(@PathVariable Long id, @RequestBody AtualizaServidorRequest atualizaServidorRequest) {
        Servidor servidorParaAtualizar = atualizaServidorRequest.convert();
        servidorParaAtualizar.setId(id);
        Servidor servidorAtualizado = atualizarServidorUseCase.executar(servidorParaAtualizar);
        return ResponseEntity.ok().body(new ServidorResponse(servidorAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        detelarServidorUseCase.executar(id);
        return ResponseEntity.ok().build();
    }
}