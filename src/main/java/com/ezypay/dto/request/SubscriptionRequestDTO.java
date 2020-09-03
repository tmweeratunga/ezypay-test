package com.ezypay.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionRequestDTO implements Serializable {

    private static final long serialVersionUID = -90000021L;

    private BigDecimal amount;
    private String type;
    private String dayOfWeekMonth;
    private Date startDate;
    private Date endDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDayOfWeekMonth() {
        return dayOfWeekMonth;
    }

    public void setDayOfWeekMonth(String dayOfWeekMonth) {
        this.dayOfWeekMonth = dayOfWeekMonth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
