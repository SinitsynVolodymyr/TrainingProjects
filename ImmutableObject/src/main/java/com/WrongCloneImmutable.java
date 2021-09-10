package com;
import java.util.Date;

/**
 * Wrong ImmutableObject
 */
public final class WrongCloneImmutable {
    private final Date start;
    private final Date end;

    public WrongCloneImmutable(Date start, Date end) {
        this.start = (Date) start.clone();
        this.end = (Date) end.clone();
    }

    public Date getStart() {
        return (Date) start.clone();
    }

    public Date getEnd() {
        return (Date) end.clone();
    }
}
