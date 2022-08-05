package africa.semicolon.soroSoke.data.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    @Id
private String email;
    private List<Article> articles = new ArrayList<>();
}
