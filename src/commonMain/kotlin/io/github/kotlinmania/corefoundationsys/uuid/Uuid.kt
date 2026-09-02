// port-lint: source uuid.rs
package io.github.kotlinmania.corefoundationsys.uuid

import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFUUID
public typealias CFUUIDRef = __CFUUID

/**
 * `CFUUIDBytes` from CoreFoundation's `uuid.rs`.
 * A 128-bit UUID representation split into 16 individual bytes.
 */
public data class CFUUIDBytes(
    public val byte0: UByte = 0u,
    public val byte1: UByte = 0u,
    public val byte2: UByte = 0u,
    public val byte3: UByte = 0u,
    public val byte4: UByte = 0u,
    public val byte5: UByte = 0u,
    public val byte6: UByte = 0u,
    public val byte7: UByte = 0u,
    public val byte8: UByte = 0u,
    public val byte9: UByte = 0u,
    public val byte10: UByte = 0u,
    public val byte11: UByte = 0u,
    public val byte12: UByte = 0u,
    public val byte13: UByte = 0u,
    public val byte14: UByte = 0u,
    public val byte15: UByte = 0u,
) {
    /**
     * Convert this 16-byte structure into a Kotlin [ByteArray].
     */
    public fun toByteArray(): ByteArray = byteArrayOf(
        byte0.toByte(), byte1.toByte(), byte2.toByte(), byte3.toByte(),
        byte4.toByte(), byte5.toByte(), byte6.toByte(), byte7.toByte(),
        byte8.toByte(), byte9.toByte(), byte10.toByte(), byte11.toByte(),
        byte12.toByte(), byte13.toByte(), byte14.toByte(), byte15.toByte(),
    )

    public companion object {
        /**
         * Construct a [CFUUIDBytes] instance from a 16-byte [ByteArray].
         */
        public fun fromByteArray(bytes: ByteArray): CFUUIDBytes {
            require(bytes.size == 16) { "CFUUIDBytes requires exactly 16 bytes, received ${bytes.size}" }
            return CFUUIDBytes(
                byte0 = bytes[0].toUByte(),
                byte1 = bytes[1].toUByte(),
                byte2 = bytes[2].toUByte(),
                byte3 = bytes[3].toUByte(),
                byte4 = bytes[4].toUByte(),
                byte5 = bytes[5].toUByte(),
                byte6 = bytes[6].toUByte(),
                byte7 = bytes[7].toUByte(),
                byte8 = bytes[8].toUByte(),
                byte9 = bytes[9].toUByte(),
                byte10 = bytes[10].toUByte(),
                byte11 = bytes[11].toUByte(),
                byte12 = bytes[12].toUByte(),
                byte13 = bytes[13].toUByte(),
                byte14 = bytes[14].toUByte(),
                byte15 = bytes[15].toUByte(),
            )
        }
    }
}

public object CFUUID {
    public const val TYPE_ID: CFTypeID = 30L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
