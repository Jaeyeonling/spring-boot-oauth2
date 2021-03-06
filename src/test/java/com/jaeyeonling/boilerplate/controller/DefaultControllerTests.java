package com.jaeyeonling.boilerplate.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class DefaultControllerTests extends ControllerSupport {
    @Test
    public void healthCheck() {
        final var response = template.getForEntity("/health", String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNull();
    }

    @Test
    public void notFound() {
        final var response = template.getForEntity("/34rtgrtgr43rtr", String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        Assertions.assertThat(response.getBody()).contains("\"code\":-102");
        Assertions.assertThat(response.getBody()).contains("\"message\":\"NOT_FOUND\"");
    }
}
