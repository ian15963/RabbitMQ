package demo_backend_api.dto;

public class PagamentoDTO {

    private Integer id;
    private Long valor;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Integer id, Long valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
