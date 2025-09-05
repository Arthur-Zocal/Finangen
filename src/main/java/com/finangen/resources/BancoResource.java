package com.finangen.resources;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/banco")
@Tag(name = "Banco", description = "API para Gerenciamento de Bancos")
public class BancoResource {
}
