// port-lint: source stream.rs
package io.github.kotlinmania.corefoundationsys.stream

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.SInt32

public class __CFReadStream
public class __CFWriteStream

public typealias CFReadStreamRef = __CFReadStream
public typealias CFWriteStreamRef = __CFWriteStream

public typealias CFStreamPropertyKey = String
public typealias CFStreamStatus = CFIndex
public typealias CFStreamEventType = CFOptionFlags
public typealias CFStreamErrorDomain = CFIndex

public data class CFStreamError(
    public val domain: CFIndex = 0,
    public val error: SInt32 = 0,
)

public const val kCFStreamStatusNotOpen: CFStreamStatus = 0
public const val kCFStreamStatusOpening: CFStreamStatus = 1
public const val kCFStreamStatusOpen: CFStreamStatus = 2
public const val kCFStreamStatusReading: CFStreamStatus = 3
public const val kCFStreamStatusWriting: CFStreamStatus = 4
public const val kCFStreamStatusAtEnd: CFStreamStatus = 5
public const val kCFStreamStatusClosed: CFStreamStatus = 6
public const val kCFStreamStatusError: CFStreamStatus = 7

public const val kCFStreamErrorDomainCustom: CFStreamErrorDomain = -1
public const val kCFStreamErrorDomainPOSIX: CFStreamErrorDomain = 1
public const val kCFStreamErrorDomainMacOSStatus: CFStreamErrorDomain = 2

public const val kCFStreamEventNone: CFStreamEventType = 0L
public const val kCFStreamEventOpenCompleted: CFStreamEventType = 1L
public const val kCFStreamEventHasBytesAvailable: CFStreamEventType = 2L
public const val kCFStreamEventCanAcceptBytes: CFStreamEventType = 4L
public const val kCFStreamEventErrorOccurred: CFStreamEventType = 8L
public const val kCFStreamEventEndEncountered: CFStreamEventType = 16L

public data class CFStreamClientContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public typealias CFReadStreamClientCallBack = (stream: CFReadStreamRef?, type: CFStreamEventType, clientCallBackInfo: Any?) -> Unit
public typealias CFWriteStreamClientCallBack = (stream: CFWriteStreamRef?, type: CFStreamEventType, clientCallBackInfo: Any?) -> Unit

public object CFStream {
    public const val APPEND_TO_FILE: CFStreamPropertyKey = "kCFStreamPropertyAppendToFile"
    public const val DATA_WRITTEN: CFStreamPropertyKey = "kCFStreamPropertyDataWritten"
    public const val FILE_CURRENT_OFFSET: CFStreamPropertyKey = "kCFStreamPropertyFileCurrentOffset"
    public const val SOCKET_NATIVE_HANDLE: CFStreamPropertyKey = "kCFStreamPropertySocketNativeHandle"
    public const val SOCKET_REMOTE_HOST_NAME: CFStreamPropertyKey = "kCFStreamPropertySocketRemoteHostName"
    public const val SOCKET_REMOTE_PORT_NUMBER: CFStreamPropertyKey = "kCFStreamPropertySocketRemotePortNumber"
    public const val SHOULD_CLOSE_NATIVE_SOCKET: String = "kCFStreamPropertyShouldCloseNativeSocket"
    public const val SOCKET_SECURITY_LEVEL: String = "kCFStreamPropertySocketSecurityLevel"

    public const val SOCKET_SECURITY_LEVEL_NONE: String = "kCFStreamSocketSecurityLevelNone"
    public const val SOCKET_SECURITY_LEVEL_SSL_V2: String = "kCFStreamSocketSecurityLevelSSLv2"
    public const val SOCKET_SECURITY_LEVEL_SSL_V3: String = "kCFStreamSocketSecurityLevelSSLv3"
    public const val SOCKET_SECURITY_LEVEL_TLS_V1: String = "kCFStreamSocketSecurityLevelTLSv1"
    public const val SOCKET_SECURITY_LEVEL_NEGOTIATED_SSL: String = "kCFStreamSocketSecurityLevelNegotiatedSSL"

    public const val SOCKS_PROXY: String = "kCFStreamPropertySOCKSProxy"
    public const val SOCKS_PROXY_HOST: String = "kCFStreamPropertySOCKSProxyHost"
    public const val SOCKS_PROXY_PORT: String = "kCFStreamPropertySOCKSProxyPort"
    public const val SOCKS_VERSION: String = "kCFStreamPropertySOCKSVersion"
    public const val SOCKET_SOCKS_VERSION4: String = "kCFStreamSocketSOCKSVersion4"
    public const val SOCKET_SOCKS_VERSION5: String = "kCFStreamSocketSOCKSVersion5"
    public const val SOCKS_USER: String = "kCFStreamPropertySOCKSUser"
    public const val SOCKS_PASSWORD: String = "kCFStreamPropertySOCKSPassword"

    public const val ERROR_DOMAIN_SOCKS: Int = 100
    public const val ERROR_DOMAIN_SSL: Int = 101
}

public object CFReadStream {
    public const val TYPE_ID: CFTypeID = 45L

    public fun getTypeID(): CFTypeID = TYPE_ID
}

public object CFWriteStream {
    public const val TYPE_ID: CFTypeID = 46L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
