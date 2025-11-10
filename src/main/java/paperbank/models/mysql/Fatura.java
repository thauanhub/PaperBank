package paperbank.models.mysql;
import org.javamoney.moneta.Money;
import java.util.Date;

public class Fatura {
    private String mes;
    private Money valorTotal;
    private Money valorPago;
    private Date dataVencimento;
}
