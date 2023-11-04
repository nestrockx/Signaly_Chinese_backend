package com.wegielek.signalychinese

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class SignalychineseApplication

fun main(args: Array<String>) {
	runApplication<SignalychineseApplication>(*args)
}
