package demo_backend_api.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoResponseErroConsumidor {

    @Autowired
    private PagamentosFacade pagamentosFacade;

    @RabbitListener(queues = {"pagamento-response-erro-queue"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());
        pagamentosFacade.erroPagamento(payload);
    }

}
