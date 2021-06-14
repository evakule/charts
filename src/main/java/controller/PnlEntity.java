package controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class PnlEntity {
    private ZonedDateTime time;
    private BigDecimal total;

    public PnlEntity(ZonedDateTime time, BigDecimal total) {
        this.time = time;
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
