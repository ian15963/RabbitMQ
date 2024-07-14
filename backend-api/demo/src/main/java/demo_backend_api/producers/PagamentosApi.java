package demo_backend_api.producers;

import demo_backend_api.dto.PagamentoDTO;
import demo_backend_api.service.PagamentosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosApi {

    @Autowired
    private PagamentosFacade pagamentosFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDTO request){
        return pagamentosFacade.solicitarPagamento(request);
    }
}
