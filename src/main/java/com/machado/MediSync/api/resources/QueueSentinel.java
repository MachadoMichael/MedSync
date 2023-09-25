package com.machado.MediSync.api.resources;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueSentinel {

    @Scheduled(fixedRate = 5000) // Executa a cada 5 segundos (5000 milissegundos)
    public void verificaFila() {
        // Coloque o código que você deseja executar aqui
        System.out.println("Verificando a fila a cada 5 segundos...");
    }
}