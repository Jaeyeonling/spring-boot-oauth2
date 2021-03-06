package com.jaeyeonling.boilerplate.security.social.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
class KakaoAccount {

    @JsonProperty("has_email")
    private boolean hasEamil;

    @JsonProperty("email_needs_agreement")
    private boolean emailAgree;

    @JsonProperty("is_email_valid")
    private boolean isEmailValid;

    private String email;

    //
    //
    //

    @Nullable String getEmail() {
        if (isEmailValid && emailAgree) {
            return email;
        }

        return null;
    }
}
