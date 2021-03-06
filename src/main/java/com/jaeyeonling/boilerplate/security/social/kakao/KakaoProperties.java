package com.jaeyeonling.boilerplate.security.social.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
class KakaoProperties {

    private String nickname;

    @JsonProperty("profile_image")
    private String profileImage;
}
