package com.chaedie.domains.auth.service

import com.chaedie.config.OAuth2Config
import com.chaedie.interfaces.OAuth2TokenResponse
import com.chaedie.interfaces.OAuth2UserResponse
import com.chaedie.interfaces.OAuthServiceInterface
import org.springframework.stereotype.Service

private const val key = "github"

@Service(key)
class GithubAuthService(
    private val config: OAuth2Config,
) : OAuthServiceInterface {

    private val oAuthInfo = config.providers[key] ?: throw TODO("Custom Exception")
    override val providerName: String = key

    override fun getToken(code: String): OAuth2TokenResponse {
        TODO("Not yet implemented")
    }

    override fun getUserInfo(accessToken: String): OAuth2UserResponse {
        TODO("Not yet implemented")
    }
}
