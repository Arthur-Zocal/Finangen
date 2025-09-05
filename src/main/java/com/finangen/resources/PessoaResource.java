package com.finangen.resources;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
@Tag(name = "Pessoa", description = "API para Gerenciamento de Pessoa")
public class PessoaResource {
}
