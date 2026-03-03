package bb.api.requests;

import lombok.Data;

@Data
public class CreateAgencyRequest {

    private String name;
    private String agency_code;

    public CreateAgencyRequest(String name, String agency_code){
        this.name = name;
        this.agency_code = agency_code;
    }
}
