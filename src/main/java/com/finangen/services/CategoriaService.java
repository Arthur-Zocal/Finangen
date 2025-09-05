package com.finangen.services;
import com.finangen.domains.Categoria;
import com.finangen.domains.dtos.CategoriaDTO;
import com.finangen.repositories.CategoriaRepository;
import com.finangen.services.exceptions.DataIntegrityViolationException;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public List<CategoriaDTO> findAll() {
        return categoriaRepo.findAll().stream()
                .map(obj -> new CategoriaDTO(obj))
                .collect(Collectors.toList());
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID: " + id));
    }

    public Categoria create(CategoriaDTO objDto) {
        objDto.setIdCategoria(null);
        Categoria newObj = new Categoria(objDto);
        return categoriaRepo.save(newObj);
    }

    public Categoria update(Long id, CategoriaDTO objDto) {
        objDto.setIdCategoria(id);
        Categoria oldObj = findById(id);
        oldObj = new Categoria(objDto);
        return categoriaRepo.save(oldObj);
    }

    /*public void delete(Long id) {
        Categoria obj = findById(id);
        if (obj.get().size() > 0) {
            throw new DataIntegrityViolationException("Banco não pode ser deletado pois possui cadastrados ativos");
        }
        categoriaRepo.deleteById(id);
    }*/

}
