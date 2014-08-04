package com

class MipinParticipant {

    String name
    String email

    static constraints = {
        email(nullable: true)
    }
}
