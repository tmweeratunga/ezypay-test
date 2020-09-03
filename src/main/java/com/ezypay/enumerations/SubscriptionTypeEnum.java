package com.ezypay.enumerations;

public enum SubscriptionTypeEnum {
    DAILY("DAILY","Daily Subscription"),
    WEEKLY("WEEKLY","Weekly Subscription"),
    MONTHLY("MONTHLY","Monthly Subscription");

    private String code;
    private String name;

    SubscriptionTypeEnum(String code, String name) {
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
        for (SubscriptionTypeEnum subscriptionTypeEnum : SubscriptionTypeEnum.values()){
            if(subscriptionTypeEnum.code.equals(code)){
                return true;
            }
        }
        return false;
    }
}
