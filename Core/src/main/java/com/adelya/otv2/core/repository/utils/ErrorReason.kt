package com.adelya.otv2.core.repository.utils

/**
 * L'enum suivant définit les status d'une ressource
 *      - NONE :                rien
 *      - NO_INTERNET :         pas d'internet
 *      - NO_RESPONSE :         lorsque le serveur ne semble pas accessible
 *      - API_RESPONSE_ERROR :  l'API répond par une erreur 500
 */
enum class ErrorReason {
    UNKNOWN,
    API_RESPONSE_ERROR,
    NO_INTERNET,
    NO_RESPONSE
}