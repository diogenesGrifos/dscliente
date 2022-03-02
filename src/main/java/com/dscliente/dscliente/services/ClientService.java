package com.dscliente.dscliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dscliente.dscliente.dto.ClientDTO;
import com.dscliente.dscliente.entities.Client;
import com.dscliente.dscliente.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list =  clientRepository.findAll(pageRequest);
		
		return list.map(x -> new ClientDTO(x));
	}
}