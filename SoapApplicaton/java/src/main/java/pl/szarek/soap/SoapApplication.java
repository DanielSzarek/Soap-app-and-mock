package pl.szarek.soap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.szarek.soap.wsdl.RegisterCallResponse;
import pl.szarek.soap.wsdl.ResultsResponse;

@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SoapClient soapClient) {
        return args -> {
            String student = "Szarek";

            if (args.length > 0) {
                student = args[0];
            }
            RegisterCallResponse registerCallResponse = soapClient.getRegisterCall(student);
            System.err.println(registerCallResponse.getExercise().getName());
            System.err.println(registerCallResponse.getExercise().getNote());

            ResultsResponse resultsResponse = soapClient.getResults(student);
            System.err.println(resultsResponse.getEntry());
        };
    }
}
