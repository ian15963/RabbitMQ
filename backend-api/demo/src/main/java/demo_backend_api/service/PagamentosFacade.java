package demo_backend_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo_backend_api.dto.PagamentoDTO;

@Service
public class PagamentosFacade {

    @Autowired
    private PagamentoRequestProdutor produtor;

    public String solicitarPagamento(PagamentoDTO pagamento){
        try{
            produtor.integrarPagamento(pagamento);
        }catch (JsonProcessingException e){
            return "Erro ao processar o pagamento";
        }
        return "Pagamento processado com sucesso";
    }

    public void sucessoPagamento(String payload) {
        System.out.println("O pagamento foi confirmado: " + payload);
    }

    public void erroPagamento(String payload) {
        System.err.println("Erro ao processar pagamento " + payload);
    }

}
