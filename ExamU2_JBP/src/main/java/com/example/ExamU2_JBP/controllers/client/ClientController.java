package com.example.ExamU2_JBP.controllers.client;

import com.example.ExamU2_JBP.controllers.client.dtos.ClientDto;
import com.example.ExamU2_JBP.models.client.Client;
import com.example.ExamU2_JBP.services.client.ClientService;
import com.example.ExamU2_JBP.utils.CustomResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = {"*"})
public class ClientController {
    @Autowired
    private ClientService clientService;

    //Get all
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Client>>> getAll() {
        return new ResponseEntity<>(this.clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CustomResponse<Client>> getOne(@PathVariable long id) {
        return new ResponseEntity<>(this.clientService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Client>> insert(@Valid @RequestBody ClientDto user) {
        return new ResponseEntity<>(this.clientService.insert(user.castToClient()), HttpStatus.CREATED);
    }
}
