package br.com.seap.api1seap.controller;

import br.com.seap.api1seap.controller.request.ServidorResquest;
import br.com.seap.api1seap.controller.request.AtualizaServidorRequest;
import br.com.seap.api1seap.controller.response.ServidorResponse;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.xml.ws.Service;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public List<ServidorResponse> getAll() {
        return ServidorResponse.converterList(buscarTodosServidoresUseCase.executar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorResponse> getById(@PathVariable Long id) {
        return buscarServidorUseCase.executar(id).map(value -> ResponseEntity.ok(new ServidorResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServidorResponse> post(@RequestBody ServidorResquest servidorResquest, UriComponentsBuilder uriBuilder) {

        Servidor servidor = servidorResquest.converter();
        criarServidorUseCase.executar(servidor);

        URI uri = uriBuilder.path("/servidor/{id}").buildAndExpand(servidor.getId()).toUri(); //Created resource address
        return ResponseEntity.created(uri).body(new ServidorResponse(servidor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorResponse> put(@PathVariable Long id, @RequestBody AtualizaServidorRequest atualizaServidorRequest) {
        Optional<Servidor> servidor = buscarServidorUseCase.executar(id);
        Servidor servidor1 = new Servidor();

        if (servidor.isPresent()){
            servidor1 = atualizaServidorRequest.atualiza(servidor.get());
        }

        atualizarServidorUseCase.executar(servidor1);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return buscarServidorUseCase.executar(id).map(value -> {
                    detelarServidorUseCase.executar(value.getId());
                    return ResponseEntity.ok().build();
                }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}