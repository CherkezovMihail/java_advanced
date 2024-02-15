package org.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        while (true) {

            LocalDateTime currentTime = LocalDateTime.now().withNano(0);

            LocalDateTime l = calculateFireTime(currentTime);
            System.out.println(l);
        }
    }

    public static LocalDateTime calculateFireTime(LocalDateTime currentTime) {
        int minutes = currentTime.getMinute();
        int currentHour = currentTime.getHour();
        int fireTimeMinutes = 0;

        if (minutes % 5 == 0) {
            fireTimeMinutes = minutes + 5;
            if (fireTimeMinutes == 60) {
                currentHour += 1;
                fireTimeMinutes = 0;
                if (currentHour > 23) {
                    currentHour = 0;
                }
            }
        } else {
            String[] minutesArray = String.valueOf(minutes).split("") ;

            int firstDigit = 0;
            int secondDigit = 0;

            if (minutesArray.length == 1) {
                secondDigit = Integer.parseInt(minutesArray[0]);
            } else {
                firstDigit = Integer.parseInt(minutesArray[0]);
                secondDigit = Integer.parseInt(minutesArray[1]);
            }

            if (secondDigit <= 5) {
                String newMinutes = firstDigit + "5";
                fireTimeMinutes = Integer.parseInt(newMinutes);
            } else if (secondDigit <= 9) {
                if (firstDigit == 5) {
                    currentHour += 1;
                    if (currentHour > 23) {
                        currentHour = 0;
                    }
                }else {
                    firstDigit += 1;
                    String newMinutes = firstDigit + "0";
                    fireTimeMinutes = Integer.parseInt(newMinutes);
                }
            }
        }

        int year = currentTime.getYear();
        int month = currentTime.getMonthValue();
        int day = currentTime.getDayOfMonth();

        String str = String.format("%d-%02d-%02d %02d:%02d", year, month, day, currentHour, fireTimeMinutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return LocalDateTime.parse(str, formatter);

//        return fireTime.atZone(ZoneId.of("GMT")).toInstant().toEpochMilli();
    }


    public LocalDateTime calculateOn15Minutes(LocalDateTime currentTime) {
        int hour = currentTime.getHour();
        int minutes = currentTime.getMinute();

        if (minutes <= 15) {
            minutes = 0;
        } else if (minutes <= 30) {
            minutes = 15;
        } else if (minutes <= 45) {
            minutes = 30;
        } else {
            minutes = 45;
        }

        int year = currentTime.getYear();
        int month = currentTime.getMonthValue();
        int day = currentTime.getDayOfMonth();

        String str = String.format("%d-%02d-%02d %02d:%02d", year, month, day, hour, minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return LocalDateTime.parse(str, formatter);

    }

    //            if (minutes < 5) {
//                fireTimeMinutes = 5;
//            } else if (minutes < 10) {
//                fireTimeMinutes = 10;
//            } else if (minutes < 15) {
//                fireTimeMinutes = 15;
//            } else if (minutes < 20) {
//                fireTimeMinutes = 20;
//            } else if (minutes < 25) {
//                fireTimeMinutes = 25;
//            } else if (minutes < 30) {
//                fireTimeMinutes = 30;
//            } else if (minutes < 35) {
//                fireTimeMinutes = 35;
//            } else if (minutes < 40) {
//                fireTimeMinutes = 40;
//            } else if (minutes < 45) {
//                fireTimeMinutes = 45;
//            } else if (minutes < 50) {
//                fireTimeMinutes = 50;
//            } else if (minutes < 55) {
//                fireTimeMinutes = 55;
//            } else {
//                hour += 1;
//                if (hour == 23) {
//                    hour = 0;
//                }
//            }
//        }
}