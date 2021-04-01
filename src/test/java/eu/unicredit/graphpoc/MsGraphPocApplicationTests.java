package eu.unicredit.graphpoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MsGraphPocApplicationTests {

    private final static String excRes = "[\"a\",\"b\"]";

    private final static String basePath = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private MSGraphManager manager;

    @Test
    void contextLoads() {
    }

    @Test
    public void smokeTest() throws Exception {
        assertThat(manager).isNotNull();
        assertThat(manager.getAppointments().size()).isEqualTo(2);
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testServiceCall() throws Exception {
        assertThat(this.restTemplate.getForObject(basePath + port + "/todaysAppointments",
                String.class)).contains(excRes);
    }


    @Autowired
    CalendarMain calendarMain;

    @Test
    public void interactive() throws Exception {
        calendarMain.execute();
    }


}
