package africa.semicolon.soroSoke.data.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    @Id
    private String id;
   private String Title;
   private String Body;
   private String username;
   @DBRef
    private List<Article> articles = new ArrayList<>();
}
