package br.com.api.authlogin.controller.pix;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.authlogin.model.TransacaoPix;
import br.com.api.authlogin.services.pix.TransacaoPixService;

@RestController
@RequestMapping("/api/pix/transacoes")
public class TransacaoPixController {

    @Autowired
    private TransacaoPixService transacaoPixService;

    @PostMapping("/pagamento")
    public ResponseEntity<TransacaoPix> iniciarTransacaoPagamento(@RequestBody TransacaoPix transacaoPix) {
        TransacaoPix novaTransacao = transacaoPixService.iniciarTransacaoPagamento(transacaoPix);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransacaoPix> iniciarTransacaoTransferencia(@RequestBody TransacaoPix transacaoPix) {
        TransacaoPix novaTransacao = transacaoPixService.iniciarTransacaoTransferencia(transacaoPix);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoPix> obterTransacaoPixPorId(@PathVariable String id) {
        Optional<TransacaoPix> transacaoPix = transacaoPixService.obterTransacaoPixPorId(id);
        return transacaoPix.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/historico/{usuarioId}")
    public ResponseEntity<List<TransacaoPix>> obterHistoricoTransacoesPorUsuario(@PathVariable String usuarioId) {
        List<TransacaoPix> historicoTransacoes = transacaoPixService.obterHistoricoTransacoesPorUsuario(usuarioId);
        return ResponseEntity.ok(historicoTransacoes);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<TransacaoPix> obterStatusTransacaoPix(@PathVariable String id) {
        Optional<TransacaoPix> transacaoPix = transacaoPixService.obterTransacaoPixPorId(id);
        return transacaoPix.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
