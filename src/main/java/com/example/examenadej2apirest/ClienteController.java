package com.example.examenadej2apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping("/post")
    public ResponseEntity<Cliente> nuevoCliente(@RequestBody Cliente c){
        return new ResponseEntity<>(repository.save(c), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public Cliente getClientePorId(@PathVariable Long id) {
        return repository.getClienteById(id);
    }

    @GetMapping("/ventasMinimasYActivo/{ventasminimas}")
    public List<Cliente> getClienteConvVentasMayorOIgual(@PathVariable Integer ventasminimas) {
        return repository.getClienteConvVentasMayorOIgual(ventasminimas);
    }
}
