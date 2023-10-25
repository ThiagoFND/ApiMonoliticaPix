package br.com.api.authlogin.services.pix;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.authlogin.dto.ChavePixDTO;
import br.com.api.authlogin.exceptions.ResourceNotFoundException;
import br.com.api.authlogin.mapper.DozerMapper;
import br.com.api.authlogin.model.ChavePix;
import br.com.api.authlogin.repositories.ChavePixRepository;

@Service
public class ChavePixService {

	private Logger logger = Logger.getLogger(ChavePixService.class.getName());

	@Autowired
	private ChavePixRepository chavePixRepository;

	public List<ChavePixDTO> findAll() {

		logger.info("Finding all dados!");

		return DozerMapper.parseListObjects(chavePixRepository.findAll(), ChavePixDTO.class);
	}

	public ChavePixDTO create(ChavePixDTO chavePix) {

		logger.info("Creating one chavepix!");
		var entity = DozerMapper.parseObject(chavePix, ChavePix.class);
		var vo = DozerMapper.parseObject(chavePixRepository.save(entity), ChavePixDTO.class);
		return vo;
	}

	public ChavePixDTO findById(String id) {

		logger.info("Finding one dados!");

		var entity = chavePixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ChavePixDTO.class);
	}

	public ChavePixDTO update(ChavePixDTO dados) {

		logger.info("Updating one dados!");

		var entity = chavePixRepository.findById(dados.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setId(dados.getId());
		entity.setChave(dados.getChave());
		entity.setDataCriacao(dados.getDataCriacao());
		entity.setTipo(dados.getTipo());

		var vo = DozerMapper.parseObject(chavePixRepository.save(entity), ChavePixDTO.class);
		return vo;
	}

	public void delete(String id) {

		logger.info("Deleting one person!");

		var entity = chavePixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		chavePixRepository.delete(entity);
	}
}
