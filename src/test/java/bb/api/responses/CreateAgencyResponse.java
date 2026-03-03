package bb.api.responses;

import bb.api.dataobjects.model.Agency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAgencyResponse {
    private String message;
    private String status_code;
    private AgencyData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AgencyData {
        private String id;
        private String name;
        private String agency_code;
    }

}
