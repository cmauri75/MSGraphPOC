package eu.unicredit.graphpoc;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AllRestController {

    private final MSGraphManager manager;

    @GetMapping(value = "/todaysAppointments", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> all() {
        return manager.getAppointments();
    }
}
