// port-lint: source socket.rs
package io.github.kotlinmania.corefoundationsys.socket

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.SInt32
import io.github.kotlinmania.corefoundationsys.data.CFDataRef

public class __CFSocket
public typealias CFSocketRef = __CFSocket

public typealias CFSocketError = CFIndex
public typealias CFSocketCallBackType = CFOptionFlags
public typealias CFSocketCallBack = (s: CFSocketRef?, type: CFSocketCallBackType, address: CFDataRef?, cdata: Any?, info: Any?) -> Unit
public typealias CFSocketNativeHandle = Int

public const val kCFSocketSuccess: CFSocketError = 0
public const val kCFSocketError: CFSocketError = -1
public const val kCFSocketTimeout: CFSocketError = -2

public data class CFSocketSignature(
    public val protocolFamily: SInt32 = 0,
    public val socketType: SInt32 = 0,
    public val protocol: SInt32 = 0,
    public val address: CFDataRef? = null,
)

public data class CFSocketContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public const val kCFSocketNoCallBack: CFSocketError = 0
public const val kCFSocketReadCallBack: CFSocketError = 1
public const val kCFSocketAcceptCallBack: CFSocketError = 2
public const val kCFSocketDataCallBack: CFSocketError = 3
public const val kCFSocketConnectCallBack: CFSocketError = 4
public const val kCFSocketWriteCallBack: CFSocketError = 8

public const val kCFSocketAutomaticallyReenableReadCallBack: CFOptionFlags = 1L
public const val kCFSocketAutomaticallyReenableAcceptCallBack: CFOptionFlags = 2L
public const val kCFSocketAutomaticallyReenableDataCallBack: CFOptionFlags = 3L
public const val kCFSocketAutomaticallyReenableWriteCallBack: CFOptionFlags = 8L
public const val kCFSocketLeaveErrors: CFOptionFlags = 64L
public const val kCFSocketCloseOnInvalidate: CFOptionFlags = 128L

public object CFSocket {
    public const val TYPE_ID: CFTypeID = 44L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val COMMAND_KEY: String = "kCFSocketCommandKey"
    public const val NAME_KEY: String = "kCFSocketNameKey"
    public const val VALUE_KEY: String = "kCFSocketValueKey"
    public const val RESULT_KEY: String = "kCFSocketResultKey"
    public const val ERROR_KEY: String = "kCFSocketErrorKey"
    public const val REGISTER_COMMAND: String = "kCFSocketRegisterCommand"
    public const val RETRIEVE_COMMAND: String = "kCFSocketRetrieveCommand"
}
