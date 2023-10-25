package br.com.api.authlogin.controller.pix;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.authlogin.dto.ChavePixDTO;
import br.com.api.authlogin.exceptions.ResourceNotFoundException;
import br.com.api.authlogin.services.pix.ChavePixService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/pix/chaves")
public class ChavePixController {

    @Autowired
    private ChavePixService chavePixService;
    
    @PostMapping(value = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ChavePixDTO create(@RequestBody ChavePixDTO chavePix) {
		return chavePixService.create(chavePix);
	}

    // endpoint pra listar dados
	@GetMapping(value = "/list",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChavePixDTO> findAll() {
		return chavePixService.findAll();
	}
	
	@GetMapping(value = "/look/{id}",
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChavePixDTO> findById(@PathVariable String id) {
	    try {
	        ChavePixDTO chavePix = chavePixService.findById(id);
	        return ResponseEntity.ok(chavePix);
	    } catch (ResourceNotFoundException e) {
	        return ResponseEntity.notFound().build();
	    }
	}



	@PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ChavePixDTO update(@PathVariable String id, @RequestBody ChavePixDTO dados) {
		// Verifique se o ID é válido (não nulo)
		if (id == null) {
			throw new IllegalArgumentException("O ID não pode ser nulo.");
		}
		// Configure o ID no objeto 'dados'
		dados.setId(id);

		// Chame o serviço 'dadosService' para atualizar os dados
		ChavePixDTO updatedDAdosd = chavePixService.update(dados);
		return updatedDAdosd;
	}
	
    @DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
    	chavePixService.delete(id);
		return ResponseEntity.noContent().build();
	}
}


