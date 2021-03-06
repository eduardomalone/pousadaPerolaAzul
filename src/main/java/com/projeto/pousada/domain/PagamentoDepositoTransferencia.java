package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.pousada.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class PagamentoDepositoTransferencia extends Pagamento{

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataPagamento;

    public PagamentoDepositoTransferencia() {
    }

    public PagamentoDepositoTransferencia(Integer id, EstadoPagamento estado, Hospedagem hospedagem, Date dataVencimento, Date dataPagamento) {
        super(id, estado, hospedagem);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }


}
