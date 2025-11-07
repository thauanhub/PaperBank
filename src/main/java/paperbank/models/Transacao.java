package paperbank.models;

import org.javamoney.moneta.Money;
import java.util.Date;

public class Transacao {
    private long idTransacao;
    private enum tipo{

    }
    private Money valor;

    private Date dataHora;
    private enum status{

    }
    private ContaBancaria origem;
    private ContaBancaria destino;



}
