package com.api.financeiro.config.feign;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("academico")
public interface AcademicoClient {

    @RequestMapping(method = RequestMethod.POST,value = "v1/academico/{cpf}")
    String updateMatricula(@PathVariable String cpf);
}
