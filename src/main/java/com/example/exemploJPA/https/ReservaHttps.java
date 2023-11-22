package com.example.exemploJPA.https;

import com.example.exemploJPA.facedes.ReservaFacede;
import com.example.exemploJPA.requests.ReservaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaHttps {
    @Autowired
    private ReservaFacede reservaFacede;

    @PostMapping()
    public ResponseEntity<Object> fazerReserva(@RequestBody ReservaRequest body){
        boolean status = reservaFacede.reservarLivro(body);
        if(status)
            return ResponseEntity.ok("Livro reservado para "+body.getUsuarioCPF());
        else
            return ResponseEntity.status(400).body("Fala ao reservar livro");
    }
}
