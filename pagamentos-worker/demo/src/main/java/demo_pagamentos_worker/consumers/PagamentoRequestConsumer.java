package demo_pagamentos_worker.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
import demo_pagamentos_worker.service.PagamentoSucessoProdutor;
import demo_pagamentos_worker.service.PagamentoErroProdutor;

@Component
public class PagamentoRequestConsumer {

    @Autowired
    private PagamentoErroProdutor erroProdutor;

    @Autowired
    private PagamentoSucessoProdutor sucessoProdutor;

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receive(@Payload Message message){
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Recebido com SUCESSO: "+ payload);
        } else {
            erroProdutor.gerarResposta("Recebido com ERRO: "+ payload);
        }
    }

}
