package is.hi;

/**
 *
 * @author Ebba
 * Kóði fenginn frá Ebbu
 *
 */


import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * The main class of the project.
 * By running the main class of {@link Application} then you start the Spring Boot system
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main (String[] args) {

        SpringApplication app =
                new SpringApplication(Application.class);
        app.run(args);
    }

}
