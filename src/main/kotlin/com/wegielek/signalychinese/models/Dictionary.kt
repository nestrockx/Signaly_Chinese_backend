package com.wegielek.signalychinese.models

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import lombok.Data
import lombok.NonNull

@Data
@Entity
@Table(name = "dictionary")
class Dictionary {
    @Id
    @GeneratedValue
    var uid: Int = 0

    @NonNull
    @Column(name = "traditional_sign")
    var traditionalSign: String = ""

    @NonNull
    @Column(name = "simplified_sign")
    var simplifiedSign: String = ""

    @NonNull
    @Column(name = "pronunciation")
    var pronunciation: String = ""

    @NonNull
    @Column(name = "pronunciation_phonetic")
    var pronunciationPhonetic: String = ""

    @NonNull
    @Column(name = "translation")
    var translation: String = ""

}