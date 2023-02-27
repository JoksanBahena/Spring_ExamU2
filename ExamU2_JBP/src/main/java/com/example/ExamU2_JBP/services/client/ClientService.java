package com.example.ExamU2_JBP.services.client;

import com.example.ExamU2_JBP.models.client.Client;
import com.example.ExamU2_JBP.models.client.ClientRepository;
import com.example.ExamU2_JBP.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Client>> getAll() {
        return new CustomResponse<>(
                this.clientRepository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Client> getOne(long id) {
        if (!this.clientRepository.existsById(id)) {
            return new CustomResponse<>(
                    null,
                    true,
                    404,
                    "No existe"
            );
        }

        return new CustomResponse<>(
                this.clientRepository.findById(id).get(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Client> insert(Client client) {
        if(this.clientRepository.existsByEmail(client.getEmail())) {
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Ya existe un cliente con ese correo"
            );
        }

        return new CustomResponse<>(
                this.clientRepository.saveAndFlush(client),
                false,
                200,
                "OK"
        );
    }
}
