import generators.Generator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Sender implements Runnable {

    String deviceIMEI;

    public void run() {
        try {
            String url = "http://localhost:8090/vital-signs";
            VitalSignsDTO vitalSigns = VitalSignsDTO.builder()
                    .deviceIMEI(deviceIMEI)
                    .bloodPressure(Generator.generateBloodPressure())
                    .bodyTemperature(Generator.generateBodyTemperature())
                    .oxygenLevel(Generator.generateOxygenInBlood())
                    .pulseRate(Generator.generatePulse())
                    .build();
            System.out.println(vitalSigns);
            WebClient client = WebClient.create();
            client.post()
                    .uri(new URI(url))
                    .body(BodyInserters.fromObject(vitalSigns))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            System.out.println("Am trimis cu succes " + deviceIMEI);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
