package com.chaedie.domains.auth.service

import com.chaedie.common.exception.CustomException
import com.chaedie.common.exception.ErrorCode
import com.chaedie.common.jwt.JwtProvider
import com.chaedie.interfaces.OAuthServiceInterface

class AuthService(
    private val oAuth2Services: Map<String, OAuthServiceInterface>,
    private val jwtProvider: JwtProvider,
) {
    fun handleAuth(state: String, code: String): String {
        // GOOGLE -> google
        val provider = state.lowercase()

        val callService = oAuth2Services[provider] ?: throw CustomException(ErrorCode.PROVIDER_NOT_FOUND, provider)
        val accessToken = callService.getToken(code)
        val userInfo = callService.getUserInfo(accessToken.accessToken)
        val token = jwtProvider.createToken(provider, userInfo.email, userInfo.name, userInfo.id)

        // platform 이 제공해주는 accessToken 을 그대로 사용해도 되고
        // 우리 서비스에서 만들어서 accessToken 을 사용해도 된다.
        // userInfo -> jwtToken


    }
}
