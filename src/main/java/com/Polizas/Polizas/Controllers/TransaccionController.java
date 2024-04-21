package com.Polizas.Polizas.Controllers;

import com.Polizas.Polizas.Persistence.Entities.Transaccion;
import com.Polizas.Polizas.Services.CurrencyExchangeService;
import com.Polizas.Polizas.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class TransaccionController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    @Autowired
    private RedisService redisService;
    @PostMapping("/api/transacciones/{usuario_id}")
    public ResponseEntity<Transaccion> pagoExtranjero(@RequestBody Transaccion transaccion, @PathVariable("usuario_id") Long usuario_id){

        if(transaccion.getId() != null) return ResponseEntity.badRequest().build();
        BigDecimal trm;
        try {
            trm = currencyExchangeService.obtainTRM(transaccion);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
           }

        transaccion.setTrm(trm);
        redisService.saveTransaccion(usuario_id,transaccion);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}