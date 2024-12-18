package com.shared.info.vo;

import com.shared.info.dto.Albums;
import com.shared.info.exception.BadRequestException;
import com.shared.info.pojo.ClientEntitlement;
import com.shared.info.pojo.CustomerEntitlements;
import feign.FeignException;
import feign.Request;

import java.util.List;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.emptyMap;

public final class TestUtils {

    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWhhcyIsImlhdCI6MTczNDUwNDA2NywiZXhwIjoxNzM0NTIyMDY3fQ.nRzPuhbUTS9Rz8M0aoWWhXND2klwdi9cJRo7av_crRMkgckDhRYla-dZVOkbTNe6JtyRkDXED24TyY4p4NiX1A";

    public static ClientEntitlement clientEntitlement() {
        return ClientEntitlement.builder().id(UUID.randomUUID().toString()).domicileCountry("CN").build();
    }

    public static CustomerEntitlements customerEntitlements() {
        return CustomerEntitlements.builder().id(UUID.randomUUID().toString()).domicileCountry("IN").build();
    }

    public static List<Albums> albums() {
        return List.of(Albums.builder().userId(1).id(1).title("A").build(),
                Albums.builder().userId(1).id(2).title("B").build());
    }

    public static Request feignRequest() {
        return Request.create(Request.HttpMethod.GET,
                "http://test.com",
                emptyMap(),
                null,
                UTF_8,
                null);
    }

    public static FeignException feignException() {
        return FeignException.errorStatus(
                "Test Exception",
                feign.Response.builder()
                        .status(400)
                        .reason("Bad Request")
                        .request(feignRequest())
                        .headers(emptyMap())
                        .build());
    }

    public static BadRequestException badRequestException(){
        return new BadRequestException("please validate the request");
    }
}
