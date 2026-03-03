package bb.api.dataobjects.model;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Agency {
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String agency_code;

}
