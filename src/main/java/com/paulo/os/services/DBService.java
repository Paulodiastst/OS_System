package com.paulo.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.os.domain.Cliente;
import com.paulo.os.domain.OS;
import com.paulo.os.domain.Tecnico;
import com.paulo.os.domain.enuns.Prioridade;
import com.paulo.os.domain.enuns.Status;
import com.paulo.os.repositories.ClienteRepository;
import com.paulo.os.repositories.OSRepository;
import com.paulo.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired // Injeção de dependencias do Spring Boot
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Valdir Cezar", "298.860.810-58", "(88)98888-8888");
		Tecnico t2 = new Tecnico(null, "Linus Torvalds", "641.760.040-88", "(88)94545-4545");
		Cliente c1 = new Cliente(null, "Betina Campos", "641.204.910-05", "(88)98888-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}

}
