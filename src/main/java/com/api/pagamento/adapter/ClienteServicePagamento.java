package com.api.pagamento.adapter;

import com.api.pagamento.entity.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url= "http://localhost:8090/produtos" , name = "viacep")
public interface ClienteServicePagamento {

    @GetMapping("/{codigo}")
    Produto buscaProdutoPor(String codigo);

    @PostMapping("baixa-estoque/{codigo}")
    Produto baixaDeEstoque(@PathVariable String codigo, @RequestParam Long quantidade);

    @PostMapping("baixa-estoque-produtos")
    List<Produto> baixaDeEstoque(@RequestBody List<Produto> produtos);
}
