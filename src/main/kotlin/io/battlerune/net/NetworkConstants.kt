package io.battlerune.net

import com.moandjiezana.toml.Toml
import io.netty.util.AttributeKey
import io.battlerune.net.channel.PlayerChannel
import java.io.File

object NetworkConstants {

    val PORT: Int
    val PACKET_LIMIT: Int
    val LOGIN_LIMIT: Int
    val LOGOUT_LIMIT: Int

    init {
        val parser = Toml().read(File("./settings.toml")).getTable("network")

        try {
            PORT = parser.getLong("server_port").toInt()
            PACKET_LIMIT = parser.getLong("packet_limit").toInt()
            LOGIN_LIMIT = parser.getLong("login_limit").toInt()
            LOGOUT_LIMIT = parser.getLong("logout_limit").toInt()
        } catch (ex: Exception) {
            throw ExceptionInInitializerError(ex)
        }
    }

    val SESSION_KEY: AttributeKey<PlayerChannel> = AttributeKey.valueOf<PlayerChannel>("session.key")

}