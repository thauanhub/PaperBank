package paperbank.models.mongo;

import lombok.Data;

@Data
public class DetalhesLog {
    private String dispositivo; // [cite: 474]
    private String codigoErro; // [cite: 474]
    private String stackTrace; // [cite: 475]
}