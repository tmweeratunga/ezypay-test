package com.ezypay.enumerations;

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
}
