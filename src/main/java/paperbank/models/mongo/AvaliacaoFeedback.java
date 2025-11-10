package paperbank.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "avaliacoes_feedback")
public class AvaliacaoFeedback {

    @Id
    private String id;
    private Long fk_idUsuario;
    private String tipoUsuario;
    private Date dataHora;
    private int ratingGeral;
    private String comentario;
    private String tags;

    private DetalhesFeedback detalhes;
}