package RestAssuredHandsOn.PoJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Comments {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;



}
