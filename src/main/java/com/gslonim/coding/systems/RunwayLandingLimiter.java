package com.gslonim.coding.systems;

import java.time.OffsetDateTime;

public interface RunwayLandingLimiter {
    boolean requestToLand(OffsetDateTime landingTime);
}
