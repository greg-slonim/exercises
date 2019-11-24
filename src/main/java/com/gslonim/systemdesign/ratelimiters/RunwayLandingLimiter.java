package com.gslonim.systemdesign.ratelimiters;

import java.time.OffsetDateTime;

public interface RunwayLandingLimiter {
    boolean requestToLand(OffsetDateTime landingTime);
}
