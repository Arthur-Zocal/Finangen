package com.finangen.resources;


import com.finangen.domains.dtos.AdminDTO;
import com.finangen.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/admin")
@Tag(name = "Admin", description = "API para Gerenciamento de Admins")
public class AdminResource {

  /*  @Autowired
    private AdminService adminService;

    @GetMapping
    @Operation(summary = "Listar todos admins", description = "Retorna uma lista dos admins cadastrados")
    public ResponseEntity<List<AdminDTO>> findAll(){
        return ResponseEntity.ok().body(adminService.findAll());
    }

*/

}
