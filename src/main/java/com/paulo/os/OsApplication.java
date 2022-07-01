package com.paulo.os;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paulo.os.domain.Cliente;
import com.paulo.os.domain.OS;
import com.paulo.os.domain.Tecnico;
import com.paulo.os.domain.enuns.Prioridade;
import com.paulo.os.domain.enuns.Status;
import com.paulo.os.repositories.ClienteRepository;
import com.paulo.os.repositories.OSRepository;
import com.paulo.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {

	@Autowired // Injeção de dependencias do Spring Boot
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Valdir Cezar", "298.860.810-58", "(88)98888-8888");
		Cliente c1 = new Cliente(null, "Betina Campos", "641.204.910-05", "(88)98888-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
