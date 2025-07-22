package com.chaedie.common.exception

class CustomException(
    private val codeInterface: CodeInterface,
    private val additionalMessage: String? = null,
) : RuntimeException(
    // RuntimeException(message: String) 에다가 message 넣어서 초기화 해주는 부분
    if (additionalMessage == null) {
        codeInterface.message
    } else {
        "${codeInterface.message} - $additionalMessage"
    }
) {
}
