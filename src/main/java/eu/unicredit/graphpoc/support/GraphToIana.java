package eu.unicredit.graphpoc.support;

import java.time.ZoneId;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Basic lookup for mapping Windows time zone identifiers to
// IANA identifiers
// Mappings taken from
// https://github.com/unicode-org/cldr/blob/master/common/supplemental/windowsZones.xml
public class GraphToIana {
    private static final Map<String, String> timeZoneIdMap =
            Stream.<AbstractMap.SimpleEntry<String, String>>of(
                    new AbstractMap.SimpleEntry<>("Dateline Standard Time", "Etc/GMT+12"),
                    new AbstractMap.SimpleEntry<>("UTC-11", "Etc/GMT+11"),
                    new AbstractMap.SimpleEntry<>("Aleutian Standard Time", "America/Adak"),
                    new AbstractMap.SimpleEntry<>("Hawaiian Standard Time", "Pacific/Honolulu"),
                    new AbstractMap.SimpleEntry<>("Marquesas Standard Time", "Pacific/Marquesas"),
                    new AbstractMap.SimpleEntry<>("Alaskan Standard Time", "America/Anchorage"),
                    new AbstractMap.SimpleEntry<>("UTC-09", "Etc/GMT+9"),
                    new AbstractMap.SimpleEntry<>("Pacific Standard Time (Mexico)", "America/Tijuana"),
                    new AbstractMap.SimpleEntry<>("UTC-08", "Etc/GMT+8"),
                    new AbstractMap.SimpleEntry<>("Pacific Standard Time", "America/Los_Angeles"),
                    new AbstractMap.SimpleEntry<>("US Mountain Standard Time", "America/Phoenix"),
                    new AbstractMap.SimpleEntry<>("Mountain Standard Time (Mexico)", "America/Chihuahua"),
                    new AbstractMap.SimpleEntry<>("Mountain Standard Time", "America/Denver"),
                    new AbstractMap.SimpleEntry<>("Central America Standard Time", "America/Guatemala"),
                    new AbstractMap.SimpleEntry<>("Central Standard Time", "America/Chicago"),
                    new AbstractMap.SimpleEntry<>("Easter Island Standard Time", "Pacific/Easter"),
                    new AbstractMap.SimpleEntry<>("Central Standard Time (Mexico)", "America/Mexico_City"),
                    new AbstractMap.SimpleEntry<>("Canada Central Standard Time", "America/Regina"),
                    new AbstractMap.SimpleEntry<>("SA Pacific Standard Time", "America/Bogota"),
                    new AbstractMap.SimpleEntry<>("Eastern Standard Time (Mexico)", "America/Cancun"),
                    new AbstractMap.SimpleEntry<>("Eastern Standard Time", "America/New_York"),
                    new AbstractMap.SimpleEntry<>("Haiti Standard Time", "America/Port-au-Prince"),
                    new AbstractMap.SimpleEntry<>("Cuba Standard Time", "America/Havana"),
                    new AbstractMap.SimpleEntry<>("US Eastern Standard Time", "America/Indianapolis"),
                    new AbstractMap.SimpleEntry<>("Turks And Caicos Standard Time", "America/Grand_Turk"),
                    new AbstractMap.SimpleEntry<>("Paraguay Standard Time", "America/Asuncion"),
                    new AbstractMap.SimpleEntry<>("Atlantic Standard Time", "America/Halifax"),
                    new AbstractMap.SimpleEntry<>("Venezuela Standard Time", "America/Caracas"),
                    new AbstractMap.SimpleEntry<>("Central Brazilian Standard Time", "America/Cuiaba"),
                    new AbstractMap.SimpleEntry<>("SA Western Standard Time", "America/La_Paz"),
                    new AbstractMap.SimpleEntry<>("Pacific SA Standard Time", "America/Santiago"),
                    new AbstractMap.SimpleEntry<>("Newfoundland Standard Time", "America/St_Johns"),
                    new AbstractMap.SimpleEntry<>("Tocantins Standard Time", "America/Araguaina"),
                    new AbstractMap.SimpleEntry<>("E. South America Standard Time", "America/Sao_Paulo"),
                    new AbstractMap.SimpleEntry<>("SA Eastern Standard Time", "America/Cayenne"),
                    new AbstractMap.SimpleEntry<>("Argentina Standard Time", "America/Buenos_Aires"),
                    new AbstractMap.SimpleEntry<>("Greenland Standard Time", "America/Godthab"),
                    new AbstractMap.SimpleEntry<>("Montevideo Standard Time", "America/Montevideo"),
                    new AbstractMap.SimpleEntry<>("Magallanes Standard Time", "America/Punta_Arenas"),
                    new AbstractMap.SimpleEntry<>("Saint Pierre Standard Time", "America/Miquelon"),
                    new AbstractMap.SimpleEntry<>("Bahia Standard Time", "America/Bahia"),
                    new AbstractMap.SimpleEntry<>("UTC-02", "Etc/GMT+2"),
                    new AbstractMap.SimpleEntry<>("Azores Standard Time", "Atlantic/Azores"),
                    new AbstractMap.SimpleEntry<>("Cape Verde Standard Time", "Atlantic/Cape_Verde"),
                    new AbstractMap.SimpleEntry<>("UTC", "Etc/GMT"),
                    new AbstractMap.SimpleEntry<>("GMT Standard Time", "Europe/London"),
                    new AbstractMap.SimpleEntry<>("Greenwich Standard Time", "Atlantic/Reykjavik"),
                    new AbstractMap.SimpleEntry<>("Sao Tome Standard Time", "Africa/Sao_Tome"),
                    new AbstractMap.SimpleEntry<>("Morocco Standard Time", "Africa/Casablanca"),
                    new AbstractMap.SimpleEntry<>("W. Europe Standard Time", "Europe/Berlin"),
                    new AbstractMap.SimpleEntry<>("Central Europe Standard Time", "Europe/Budapest"),
                    new AbstractMap.SimpleEntry<>("Romance Standard Time", "Europe/Paris"),
                    new AbstractMap.SimpleEntry<>("Central European Standard Time", "Europe/Warsaw"),
                    new AbstractMap.SimpleEntry<>("W. Central Africa Standard Time", "Africa/Lagos"),
                    new AbstractMap.SimpleEntry<>("Jordan Standard Time", "Asia/Amman"),
                    new AbstractMap.SimpleEntry<>("GTB Standard Time", "Europe/Bucharest"),
                    new AbstractMap.SimpleEntry<>("Middle East Standard Time", "Asia/Beirut"),
                    new AbstractMap.SimpleEntry<>("Egypt Standard Time", "Africa/Cairo"),
                    new AbstractMap.SimpleEntry<>("E. Europe Standard Time", "Europe/Chisinau"),
                    new AbstractMap.SimpleEntry<>("Syria Standard Time", "Asia/Damascus"),
                    new AbstractMap.SimpleEntry<>("West Bank Standard Time", "Asia/Hebron"),
                    new AbstractMap.SimpleEntry<>("South Africa Standard Time", "Africa/Johannesburg"),
                    new AbstractMap.SimpleEntry<>("FLE Standard Time", "Europe/Kiev"),
                    new AbstractMap.SimpleEntry<>("Israel Standard Time", "Asia/Jerusalem"),
                    new AbstractMap.SimpleEntry<>("Kaliningrad Standard Time", "Europe/Kaliningrad"),
                    new AbstractMap.SimpleEntry<>("Sudan Standard Time", "Africa/Khartoum"),
                    new AbstractMap.SimpleEntry<>("Libya Standard Time", "Africa/Tripoli"),
                    new AbstractMap.SimpleEntry<>("Namibia Standard Time", "Africa/Windhoek"),
                    new AbstractMap.SimpleEntry<>("Arabic Standard Time", "Asia/Baghdad"),
                    new AbstractMap.SimpleEntry<>("Turkey Standard Time", "Europe/Istanbul"),
                    new AbstractMap.SimpleEntry<>("Arab Standard Time", "Asia/Riyadh"),
                    new AbstractMap.SimpleEntry<>("Belarus Standard Time", "Europe/Minsk"),
                    new AbstractMap.SimpleEntry<>("Russian Standard Time", "Europe/Moscow"),
                    new AbstractMap.SimpleEntry<>("E. Africa Standard Time", "Africa/Nairobi"),
                    new AbstractMap.SimpleEntry<>("Iran Standard Time", "Asia/Tehran"),
                    new AbstractMap.SimpleEntry<>("Arabian Standard Time", "Asia/Dubai"),
                    new AbstractMap.SimpleEntry<>("Astrakhan Standard Time", "Europe/Astrakhan"),
                    new AbstractMap.SimpleEntry<>("Azerbaijan Standard Time", "Asia/Baku"),
                    new AbstractMap.SimpleEntry<>("Russia Time Zone 3", "Europe/Samara"),
                    new AbstractMap.SimpleEntry<>("Mauritius Standard Time", "Indian/Mauritius"),
                    new AbstractMap.SimpleEntry<>("Saratov Standard Time", "Europe/Saratov"),
                    new AbstractMap.SimpleEntry<>("Georgian Standard Time", "Asia/Tbilisi"),
                    new AbstractMap.SimpleEntry<>("Volgograd Standard Time", "Europe/Volgograd"),
                    new AbstractMap.SimpleEntry<>("Caucasus Standard Time", "Asia/Yerevan"),
                    new AbstractMap.SimpleEntry<>("Afghanistan Standard Time", "Asia/Kabul"),
                    new AbstractMap.SimpleEntry<>("West Asia Standard Time", "Asia/Tashkent"),
                    new AbstractMap.SimpleEntry<>("Ekaterinburg Standard Time", "Asia/Yekaterinburg"),
                    new AbstractMap.SimpleEntry<>("Pakistan Standard Time", "Asia/Karachi"),
                    new AbstractMap.SimpleEntry<>("Qyzylorda Standard Time", "Asia/Qyzylorda"),
                    new AbstractMap.SimpleEntry<>("India Standard Time", "Asia/Calcutta"),
                    new AbstractMap.SimpleEntry<>("Sri Lanka Standard Time", "Asia/Colombo"),
                    new AbstractMap.SimpleEntry<>("Nepal Standard Time", "Asia/Katmandu"),
                    new AbstractMap.SimpleEntry<>("Central Asia Standard Time", "Asia/Almaty"),
                    new AbstractMap.SimpleEntry<>("Bangladesh Standard Time", "Asia/Dhaka"),
                    new AbstractMap.SimpleEntry<>("Omsk Standard Time", "Asia/Omsk"),
                    new AbstractMap.SimpleEntry<>("Myanmar Standard Time", "Asia/Rangoon"),
                    new AbstractMap.SimpleEntry<>("SE Asia Standard Time", "Asia/Bangkok"),
                    new AbstractMap.SimpleEntry<>("Altai Standard Time", "Asia/Barnaul"),
                    new AbstractMap.SimpleEntry<>("W. Mongolia Standard Time", "Asia/Hovd"),
                    new AbstractMap.SimpleEntry<>("North Asia Standard Time", "Asia/Krasnoyarsk"),
                    new AbstractMap.SimpleEntry<>("N. Central Asia Standard Time", "Asia/Novosibirsk"),
                    new AbstractMap.SimpleEntry<>("Tomsk Standard Time", "Asia/Tomsk"),
                    new AbstractMap.SimpleEntry<>("China Standard Time", "Asia/Shanghai"),
                    new AbstractMap.SimpleEntry<>("North Asia East Standard Time", "Asia/Irkutsk"),
                    new AbstractMap.SimpleEntry<>("Singapore Standard Time", "Asia/Singapore"),
                    new AbstractMap.SimpleEntry<>("W. Australia Standard Time", "Australia/Perth"),
                    new AbstractMap.SimpleEntry<>("Taipei Standard Time", "Asia/Taipei"),
                    new AbstractMap.SimpleEntry<>("Ulaanbaatar Standard Time", "Asia/Ulaanbaatar"),
                    new AbstractMap.SimpleEntry<>("Aus Central W. Standard Time", "Australia/Eucla"),
                    new AbstractMap.SimpleEntry<>("Transbaikal Standard Time", "Asia/Chita"),
                    new AbstractMap.SimpleEntry<>("Tokyo Standard Time", "Asia/Tokyo"),
                    new AbstractMap.SimpleEntry<>("North Korea Standard Time", "Asia/Pyongyang"),
                    new AbstractMap.SimpleEntry<>("Korea Standard Time", "Asia/Seoul"),
                    new AbstractMap.SimpleEntry<>("Yakutsk Standard Time", "Asia/Yakutsk"),
                    new AbstractMap.SimpleEntry<>("Cen. Australia Standard Time", "Australia/Adelaide"),
                    new AbstractMap.SimpleEntry<>("AUS Central Standard Time", "Australia/Darwin"),
                    new AbstractMap.SimpleEntry<>("E. Australia Standard Time", "Australia/Brisbane"),
                    new AbstractMap.SimpleEntry<>("AUS Eastern Standard Time", "Australia/Sydney"),
                    new AbstractMap.SimpleEntry<>("West Pacific Standard Time", "Pacific/Port_Moresby"),
                    new AbstractMap.SimpleEntry<>("Tasmania Standard Time", "Australia/Hobart"),
                    new AbstractMap.SimpleEntry<>("Vladivostok Standard Time", "Asia/Vladivostok"),
                    new AbstractMap.SimpleEntry<>("Lord Howe Standard Time", "Australia/Lord_Howe"),
                    new AbstractMap.SimpleEntry<>("Bougainville Standard Time", "Pacific/Bougainville"),
                    new AbstractMap.SimpleEntry<>("Russia Time Zone 10", "Asia/Srednekolymsk"),
                    new AbstractMap.SimpleEntry<>("Magadan Standard Time", "Asia/Magadan"),
                    new AbstractMap.SimpleEntry<>("Norfolk Standard Time", "Pacific/Norfolk"),
                    new AbstractMap.SimpleEntry<>("Sakhalin Standard Time", "Asia/Sakhalin"),
                    new AbstractMap.SimpleEntry<>("Central Pacific Standard Time", "Pacific/Guadalcanal"),
                    new AbstractMap.SimpleEntry<>("Russia Time Zone 11", "Asia/Kamchatka"),
                    new AbstractMap.SimpleEntry<>("New Zealand Standard Time", "Pacific/Auckland"),
                    new AbstractMap.SimpleEntry<>("UTC+12", "Etc/GMT-12"),
                    new AbstractMap.SimpleEntry<>("Fiji Standard Time", "Pacific/Fiji"),
                    new AbstractMap.SimpleEntry<>("Chatham Islands Standard Time", "Pacific/Chatham"),
                    new AbstractMap.SimpleEntry<>("UTC+13", "Etc/GMT-13"),
                    new AbstractMap.SimpleEntry<>("Tonga Standard Time", "Pacific/Tongatapu"),
                    new AbstractMap.SimpleEntry<>("Samoa Standard Time", "Pacific/Apia"),
                    new AbstractMap.SimpleEntry<>("Line Islands Standard Time", "Pacific/Kiritimati")
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public static String getIanaFromWindows(String windowsTimeZone) {
        String iana = timeZoneIdMap.get(windowsTimeZone);

        // If a mapping was not found, assume the value passed
        // was already an IANA identifier
        return (iana == null) ? windowsTimeZone : iana;
    }

    public static ZoneId getZoneIdFromWindows(String windowsTimeZone) {
        String timeZoneId = getIanaFromWindows(windowsTimeZone);

        return ZoneId.of(timeZoneId);
    }
}