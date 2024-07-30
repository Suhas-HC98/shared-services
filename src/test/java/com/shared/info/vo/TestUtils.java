package com.shared.info.vo;

import com.shared.info.dto.Albums;
import com.shared.info.pojo.ClientEntitlement;
import com.shared.info.pojo.CustomerEntitlements;

import java.util.List;
import java.util.UUID;

public final class TestUtils {

    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWhhcyIsImlhdCI6MTcyMjMyNTkzOSwiZXhwIjoxNzIyMzQzOTM5fQ.V67XBZp7PLBLnL3xXQb9J0miF8HrpFbgUf0qG6vuYvdPvdcmqDRM-TAFPiZvmH8r-3aLxAYmUWJcyKPcHK2aTA";

    public static ClientEntitlement clientEntitlement() {
        return ClientEntitlement.builder().id(UUID.randomUUID().toString()).domicileCountry("CN").build();
    }

    public static CustomerEntitlements customerEntitlements() {
        return CustomerEntitlements.builder().id(UUID.randomUUID().toString()).domicileCountry("IN").build();
    }

    public static List<Albums> albums(){
        return List.of(Albums.builder().userId(1).id(1).title("A").build(),
                Albums.builder().userId(1).id(2).title("B").build());
    }
}
