package eu.unicredit.graphpoc;

import com.microsoft.graph.models.extensions.DateTimeTimeZone;
import com.microsoft.graph.models.extensions.Event;
import com.microsoft.graph.models.extensions.User;
import eu.unicredit.graphpoc.support.Authentication;
import eu.unicredit.graphpoc.support.Graph;
import eu.unicredit.graphpoc.support.GraphToIana;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@Slf4j
public class CalendarMain {

    private final static String appId = "21e68da3-04f3-472b-a168-c210748c6c56";
    private final static String[] appScopes = "User.Read,MailboxSettings.Read,Calendars.ReadWrite".split(",");

    private static String formatDateTimeTimeZone(DateTimeTimeZone date) {
        LocalDateTime dateTime = LocalDateTime.parse(date.dateTime);

        return dateTime.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                " (" + date.timeZone + ")";
    }

    private static void listCalendarEvents(String accessToken, String timeZone) {
        ZoneId tzId = GraphToIana.getZoneIdFromWindows("Pacific Standard Time");

        // Get midnight of the first day of the week (assumed Sunday)
        // in the user's timezone, then convert to UTC
        ZonedDateTime startOfWeek = ZonedDateTime.now(tzId)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
                .truncatedTo(ChronoUnit.DAYS)
                .withZoneSameInstant(ZoneId.of("UTC"));

        // Add 7 days to get the end of the week
        ZonedDateTime endOfWeek = startOfWeek.plusDays(7);

        // Get the user's events
        List<Event> events = Graph.getCalendarView(accessToken,
                startOfWeek, endOfWeek, timeZone);

        log.info("Events:");

        for (Event event : events) {
            log.info("Subject: " + event.subject);
            log.info("  Organizer: " + event.organizer.emailAddress.name);
            log.info("  Start: " + formatDateTimeTimeZone(event.start));
            log.info("  End: " + formatDateTimeTimeZone(event.end));
        }

        log.info(" ");
    }


    public void execute() {
        log.info("Java Graph Tutorial");
        log.info("");

        // Get an access token
        Authentication.initialize(appId);
        final String accessToken = Authentication.getUserAccessToken(appScopes);

        // Greet the user
        User user = Graph.getUser(accessToken);
        log.info("Welcome " + user.displayName);
        log.info("Time zone: " + user.mailboxSettings.timeZone);
        log.info("");


        log.info("Access token: " + accessToken);
        listCalendarEvents(accessToken, user.mailboxSettings.timeZone != null ? user.mailboxSettings.timeZone : "W. Europe Standard Time");
    }

}

