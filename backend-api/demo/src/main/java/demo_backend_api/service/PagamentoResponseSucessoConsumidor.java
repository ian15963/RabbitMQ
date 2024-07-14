package demo_backend_api.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoResponseSucessoConsumidor {

    @Autowired
    private PagamentosFacade pagamentosFacade;

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message){
        String paylod = String.valueOf(message.getPayload());
        pagamentosFacade.sucessoPagamento(paylod);
    }

}
