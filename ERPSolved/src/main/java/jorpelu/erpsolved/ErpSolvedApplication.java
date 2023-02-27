package jorpelu.erpsolved;

import jorpelu.erpsolved.upload.StorageService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ErpSolvedApplication {

    public static void main(String[]args){
        SpringApplication.run(ErpSolvedApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args) ->{
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            System.out.println( passwordEncoder.encode("1234"));
            storageService.deleteAll();
            storageService.init();

        };
    }

}
