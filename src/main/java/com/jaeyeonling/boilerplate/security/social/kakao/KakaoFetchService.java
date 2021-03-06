package com.jaeyeonling.boilerplate.security.social.kakao;

import com.jaeyeonling.boilerplate.properties.SecurityProperties;
import com.jaeyeonling.boilerplate.security.social.SocialFetchService;
import com.jaeyeonling.boilerplate.type.AuthProvider;
import com.jaeyeonling.boilerplate.utils.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KakaoFetchService extends SocialFetchService<KakaoUserInfo> {

    @Autowired
    public KakaoFetchService(
            final SecurityProperties securityProperties,
            final RestTemplate restTemplate
    ) {
        super(
                securityProperties,
                restTemplate
        );
    }

    //
    //
    //

    @Override
    protected AuthProvider getAuthProvider() {
        return AuthProvider.KAKAO;
    }

    @Override
    protected Class<KakaoUserInfo> getSocialUserInfoType() {
        return KakaoUserInfo.class;
    }
}
