package paperbank.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Data
@Document(collection = "logs_eventos")
public class LogEvento {

    @Id
    private String id;

    private Date dataHora;
    private String tipo;
    private Long fk_idUsuario;
    private String ipOrigem;
    private String nivelSeveridade;
    private String mensagem;

    private DetalhesLog detalhesAdicionais;
}