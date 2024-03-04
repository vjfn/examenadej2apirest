package com.example.examenadej2apirest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Cliente getClienteById(Long id);

    @Query("SELECT c FROM Cliente c WHERE c.totalDeVentas >= :totalventas and c.estado ='activo'")
    List<Cliente> getClienteConvVentasMayorOIgual(Integer totalventas);





}
