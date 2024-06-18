package app_52_data_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataTime {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
        System.out.println("ZonedDateTime.zonedDateTime: " + zonedDateTime);
        System.out.println("ZonedDateTime.toInstant: " + zonedDateTime.toInstant());
        System.out.println("ZonedDateTime.toEpochMilli: " + zonedDateTime.toInstant().toEpochMilli());
        System.out.println("ZonedDateTime.plus: " + zonedDateTime.plus(Duration.ofDays(1)));
        System.out.println("ZonedDateTime.getMonth: " + zonedDateTime.getMonth());
        System.out.println("ZonedDateTime.isAfter: " + zonedDateTime.isAfter(zonedDateTime2));
        System.out.println("ZonedDateTime.isBefore: " + zonedDateTime.isBefore(zonedDateTime2));
        System.out.println("ZonedDateTime.isEqual: " + zonedDateTime.isEqual(zonedDateTime2));
        System.out.println("ZonedDateTime.plus: " + zonedDateTime.truncatedTo(ChronoUnit.DAYS));
        System.out.println("LocalDateTime: " + LocalDateTime.of(2018,1,1,1,1));
        System.out.println("LocalDateTime.now: " + LocalDateTime.now(ZoneOffset.UTC)); // локкадьно время в UTC
        System.out.println("LocalDateTime.now: " + LocalDateTime.now());
        System.out.println("LocalDateTime.toLocalTime: " + LocalDateTime.now().toLocalTime());
        System.out.println("LocalDateTime.toLocalDate: " + LocalDateTime.now().toLocalDate());
        System.out.println("LocalDateTime.now: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("LocalDateTime.parse: " + LocalDateTime.parse("2018-12-30T19:34:50.63").format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("LocalDateTime.ZoneId: " + LocalDateTime.now().toInstant(ZoneId.of("America/Los_Angeles").getRules().getOffset(LocalDateTime.now())));
        System.out.println("LocalDateTime.ZoneId: " + LocalDateTime.now().toInstant(ZoneId.of("America/Los_Angeles").getRules().getOffset(LocalDateTime.now())));
        System.out.println("LocalDateTime.with: " + LocalDateTime.now().with(template -> template.plus(1L, ChronoUnit.DAYS)));
        System.out.println("Period.between.days: " + Period.between(LocalDate.of(2018,1,1), LocalDate.now()).get(ChronoUnit.DAYS));
        System.out.println("Period.between.month: " + Period.between(LocalDate.of(2018,1,1), LocalDate.now()).get(ChronoUnit.MONTHS));
        System.out.println("Period.between.year: " + Period.between(LocalDate.of(2018,1,1), LocalDate.now()).get(ChronoUnit.YEARS));
        System.out.println("ChronoUnit.between: " + ChronoUnit.DAYS.between(LocalDate.of(2018,1,1), LocalDate.now()));
        System.out.println("Instant.atZone: " + Instant.now().atZone(ZoneId.of("America/Los_Angeles")));

//        System.out.println("getMonth: " + zonedDateTime.format(Duration.ofDays()));


    }
}
