package africa.semicolon.soroSoke;

import africa.semicolon.soroSoke.controller.UserController;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {

    private static  final Scanner input = new Scanner(System.in);
    private UserController userController = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        Intro();
    }

    private static void Intro() {
        System.out.println("""
                            WELCOME TO SOROSOKE BLOG 
                -> Register
                -> Login
                -> Create a Blog
                -> Add Articles
                -> View Article
                -> Delete Article
                -> Press 0 to Exit       
                """);

    }
}
