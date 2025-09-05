package com.finangen.resources;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contabancaria")
@Tag(name = "Conta Bancaria", description = "API para Gerenciamento de Conta Bancaria")
public class ContaBancariaResource {
}
