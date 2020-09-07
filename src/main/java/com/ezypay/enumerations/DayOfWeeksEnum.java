package com.ezypay.enumerations;

import java.time.DayOfWeek;

public enum DayOfWeeksEnum {
    MONDAY("MONDAY","MONDAY"),
    TUESDAY("TUESDAY","TUESDAY"),
    WEDNESDAY("WEDNESDAY","WEDNESDAY"),
    THURSDAY("THURSDAY","THURSDAY"),
    FRIDAY("FRIDAY","FRIDAY"),
    SATURDAY("SATURDAY","SATURDAY"),
    SUNDAY("SUNDAY","SUNDAY");

    private String code;
    private String name;

    DayOfWeeksEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static boolean contains(String code){
        for (DayOfWeeksEnum dayOfWeeksEnum : DayOfWeeksEnum.values()){
            if(dayOfWeeksEnum.code.equals(code)){
                return true;
            }
        }
        return false;
    }

    public static DayOfWeek getDayOfWeek(String dayOfWeek){
        if(MONDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.MONDAY;
        } else if (TUESDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.TUESDAY;
        } else if (WEDNESDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.WEDNESDAY;
        } else if (THURSDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.THURSDAY;
        } else if (FRIDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.FRIDAY;
        } else if (SATURDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.SATURDAY;
        } else if (SUNDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.SUNDAY;
        }
        return null;
    }
}
