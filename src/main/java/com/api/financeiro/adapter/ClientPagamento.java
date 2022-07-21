package com.api.financeiro.adapter;

import com.api.pagamento.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientPagamento {

    private ClienteServicePagamento clienteServicePagamento;


    List<Produto> baixaDeEstoque(List<Produto> produtos){
        return clienteServicePagamento.baixaDeEstoque(produtos);
    }
}
