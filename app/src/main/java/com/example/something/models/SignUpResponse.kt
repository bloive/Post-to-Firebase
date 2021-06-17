package com.example.something.models

data class SignUpResponse(
    val idToken: String?,
    val email: String?,
    val refreshToken: String?,
    val expiresIn: String?,
    val localId: String?
) {
    override fun toString(): String =
        "IDTOKEN - $idToken, EMAIL - $email, REFRESHTOKEN - $refreshToken, EXPIRESIN - $expiresIn, LOCALID - $localId"
}

