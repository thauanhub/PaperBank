package paperbank.models;

import org.javamoney.moneta.Money;

import java.util.Date;

public class Emprestimo {
    private Money valor;
    private float juros;
    private int parcelas;
    private Date dataContratacao;
}
