// port-lint: source string.rs
package io.github.kotlinmania.corefoundationsys.string

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags

/**
 * `CFStringCompareFlags` from CoreFoundation's `string.rs` (upstream
 * `pub type CFStringCompareFlags = CFOptionFlags`).
 */
public typealias CFStringCompareFlags = CFOptionFlags

public const val kCFCompareCaseInsensitive: CFStringCompareFlags = 1L
public const val kCFCompareBackwards: CFStringCompareFlags = 4L
public const val kCFCompareAnchored: CFStringCompareFlags = 8L
public const val kCFCompareNonliteral: CFStringCompareFlags = 16L
public const val kCFCompareLocalized: CFStringCompareFlags = 32L
public const val kCFCompareNumerically: CFStringCompareFlags = 64L
public const val kCFCompareDiacriticInsensitive: CFStringCompareFlags = 128L
public const val kCFCompareWidthInsensitive: CFStringCompareFlags = 256L
public const val kCFCompareForcedOrdering: CFStringCompareFlags = 512L

/**
 * `CFStringEncoding` from CoreFoundation's `string.rs` (upstream
 * `pub type CFStringEncoding = UInt32`). Encoding identifier values
 * accepted by `CFStringCreateWithBytes`, `CFStringGetBytes`,
 * `CFStringGetCStringPtr`, etc.
 */
public typealias CFStringEncoding = UInt

/** `UniChar` from CoreFoundation's `string.rs` (upstream `pub type UniChar = c_ushort`). */
public typealias UniChar = UShort

public const val kCFStringEncodingMacRoman: CFStringEncoding = 0u
public const val kCFStringEncodingWindowsLatin1: CFStringEncoding = 0x0500u
public const val kCFStringEncodingISOLatin1: CFStringEncoding = 0x0201u
public const val kCFStringEncodingNextStepLatin: CFStringEncoding = 0x0B01u
public const val kCFStringEncodingASCII: CFStringEncoding = 0x0600u
public const val kCFStringEncodingUnicode: CFStringEncoding = 0x0100u
public const val kCFStringEncodingUTF8: CFStringEncoding = 0x08000100u
public const val kCFStringEncodingNonLossyASCII: CFStringEncoding = 0x0BFFu
public const val kCFStringEncodingUTF16: CFStringEncoding = 0x0100u
public const val kCFStringEncodingUTF16BE: CFStringEncoding = 0x10000100u
public const val kCFStringEncodingUTF16LE: CFStringEncoding = 0x14000100u
public const val kCFStringEncodingUTF32: CFStringEncoding = 0x0c000100u
public const val kCFStringEncodingUTF32BE: CFStringEncoding = 0x18000100u
public const val kCFStringEncodingUTF32LE: CFStringEncoding = 0x1c000100u
public const val kCFStringEncodingMacJapanese: CFStringEncoding = 1u
public const val kCFStringEncodingMacChineseTrad: CFStringEncoding = 2u
public const val kCFStringEncodingMacKorean: CFStringEncoding = 3u
public const val kCFStringEncodingMacArabic: CFStringEncoding = 4u
public const val kCFStringEncodingMacHebrew: CFStringEncoding = 5u
public const val kCFStringEncodingMacGreek: CFStringEncoding = 6u
public const val kCFStringEncodingMacCyrillic: CFStringEncoding = 7u
public const val kCFStringEncodingMacDevanagari: CFStringEncoding = 9u
public const val kCFStringEncodingMacGurmukhi: CFStringEncoding = 10u
public const val kCFStringEncodingMacGujarati: CFStringEncoding = 11u
public const val kCFStringEncodingMacOriya: CFStringEncoding = 12u
public const val kCFStringEncodingMacBengali: CFStringEncoding = 13u
public const val kCFStringEncodingMacTamil: CFStringEncoding = 14u
public const val kCFStringEncodingMacTelugu: CFStringEncoding = 15u
public const val kCFStringEncodingMacKannada: CFStringEncoding = 16u
public const val kCFStringEncodingMacMalayalam: CFStringEncoding = 17u
public const val kCFStringEncodingMacSinhalese: CFStringEncoding = 18u
public const val kCFStringEncodingMacBurmese: CFStringEncoding = 19u
public const val kCFStringEncodingMacKhmer: CFStringEncoding = 20u
public const val kCFStringEncodingMacThai: CFStringEncoding = 21u
public const val kCFStringEncodingMacLaotian: CFStringEncoding = 22u
public const val kCFStringEncodingMacGeorgian: CFStringEncoding = 23u
public const val kCFStringEncodingMacArmenian: CFStringEncoding = 24u
public const val kCFStringEncodingMacChineseSimp: CFStringEncoding = 25u
public const val kCFStringEncodingMacTibetan: CFStringEncoding = 26u
public const val kCFStringEncodingMacMongolian: CFStringEncoding = 27u
public const val kCFStringEncodingMacEthiopic: CFStringEncoding = 28u
public const val kCFStringEncodingMacCentralEurRoman: CFStringEncoding = 29u
public const val kCFStringEncodingMacVietnamese: CFStringEncoding = 30u
public const val kCFStringEncodingMacExtArabic: CFStringEncoding = 31u
public const val kCFStringEncodingMacSymbol: CFStringEncoding = 33u
public const val kCFStringEncodingMacDingbats: CFStringEncoding = 34u
public const val kCFStringEncodingMacTurkish: CFStringEncoding = 35u
public const val kCFStringEncodingMacCroatian: CFStringEncoding = 36u
public const val kCFStringEncodingMacIcelandic: CFStringEncoding = 37u
public const val kCFStringEncodingMacRomanian: CFStringEncoding = 38u
public const val kCFStringEncodingMacCeltic: CFStringEncoding = 39u
public const val kCFStringEncodingMacGaelic: CFStringEncoding = 40u
public const val kCFStringEncodingMacFarsi: CFStringEncoding = 0x8Cu
public const val kCFStringEncodingMacUkrainian: CFStringEncoding = 0x98u
public const val kCFStringEncodingMacInuit: CFStringEncoding = 0xECu
public const val kCFStringEncodingMacVT100: CFStringEncoding = 0xFCu
public const val kCFStringEncodingMacHFS: CFStringEncoding = 0xFFu
public const val kCFStringEncodingISOLatin2: CFStringEncoding = 0x0202u
public const val kCFStringEncodingISOLatin3: CFStringEncoding = 0x0203u
public const val kCFStringEncodingISOLatin4: CFStringEncoding = 0x0204u
public const val kCFStringEncodingISOLatinCyrillic: CFStringEncoding = 0x0205u
public const val kCFStringEncodingISOLatinArabic: CFStringEncoding = 0x0206u
public const val kCFStringEncodingISOLatinGreek: CFStringEncoding = 0x0207u
public const val kCFStringEncodingISOLatinHebrew: CFStringEncoding = 0x0208u
public const val kCFStringEncodingISOLatin5: CFStringEncoding = 0x0209u
public const val kCFStringEncodingISOLatin6: CFStringEncoding = 0x020Au
public const val kCFStringEncodingISOLatinThai: CFStringEncoding = 0x020Bu
public const val kCFStringEncodingISOLatin7: CFStringEncoding = 0x020Du
public const val kCFStringEncodingISOLatin8: CFStringEncoding = 0x020Eu
public const val kCFStringEncodingISOLatin9: CFStringEncoding = 0x020Fu
public const val kCFStringEncodingISOLatin10: CFStringEncoding = 0x0210u
public const val kCFStringEncodingDOSLatinUS: CFStringEncoding = 0x0400u
public const val kCFStringEncodingDOSGreek: CFStringEncoding = 0x0405u
public const val kCFStringEncodingDOSBalticRim: CFStringEncoding = 0x0406u
public const val kCFStringEncodingDOSLatin1: CFStringEncoding = 0x0410u
public const val kCFStringEncodingDOSGreek1: CFStringEncoding = 0x0411u
public const val kCFStringEncodingDOSLatin2: CFStringEncoding = 0x0412u
public const val kCFStringEncodingDOSCyrillic: CFStringEncoding = 0x0413u
public const val kCFStringEncodingDOSTurkish: CFStringEncoding = 0x0414u
public const val kCFStringEncodingDOSPortuguese: CFStringEncoding = 0x0415u
public const val kCFStringEncodingDOSIcelandic: CFStringEncoding = 0x0416u
public const val kCFStringEncodingDOSHebrew: CFStringEncoding = 0x0417u
public const val kCFStringEncodingDOSCanadianFrench: CFStringEncoding = 0x0418u
public const val kCFStringEncodingDOSArabic: CFStringEncoding = 0x0419u
public const val kCFStringEncodingDOSNordic: CFStringEncoding = 0x041Au
public const val kCFStringEncodingDOSRussian: CFStringEncoding = 0x041Bu
public const val kCFStringEncodingDOSGreek2: CFStringEncoding = 0x041Cu
public const val kCFStringEncodingDOSThai: CFStringEncoding = 0x041Du
public const val kCFStringEncodingDOSJapanese: CFStringEncoding = 0x0420u
public const val kCFStringEncodingDOSChineseSimplif: CFStringEncoding = 0x0421u
public const val kCFStringEncodingDOSKorean: CFStringEncoding = 0x0422u
public const val kCFStringEncodingDOSChineseTrad: CFStringEncoding = 0x0423u
public const val kCFStringEncodingWindowsLatin2: CFStringEncoding = 0x0501u
public const val kCFStringEncodingWindowsCyrillic: CFStringEncoding = 0x0502u
public const val kCFStringEncodingWindowsGreek: CFStringEncoding = 0x0503u
public const val kCFStringEncodingWindowsLatin5: CFStringEncoding = 0x0504u
public const val kCFStringEncodingWindowsHebrew: CFStringEncoding = 0x0505u
public const val kCFStringEncodingWindowsArabic: CFStringEncoding = 0x0506u
public const val kCFStringEncodingWindowsBalticRim: CFStringEncoding = 0x0507u
public const val kCFStringEncodingWindowsVietnamese: CFStringEncoding = 0x0508u
public const val kCFStringEncodingWindowsKoreanJohab: CFStringEncoding = 0x0510u
public const val kCFStringEncodingANSEL: CFStringEncoding = 0x0601u
public const val kCFStringEncodingJIS_X0201_76: CFStringEncoding = 0x0620u
public const val kCFStringEncodingJIS_X0208_83: CFStringEncoding = 0x0621u
public const val kCFStringEncodingJIS_X0208_90: CFStringEncoding = 0x0622u
public const val kCFStringEncodingJIS_X0212_90: CFStringEncoding = 0x0623u
public const val kCFStringEncodingJIS_C6226_78: CFStringEncoding = 0x0624u
public const val kCFStringEncodingShiftJIS_X0213: CFStringEncoding = 0x0628u
public const val kCFStringEncodingShiftJIS_X0213_MenKuTen: CFStringEncoding = 0x0629u
public const val kCFStringEncodingGB_2312_80: CFStringEncoding = 0x0630u
public const val kCFStringEncodingGBK_95: CFStringEncoding = 0x0631u
public const val kCFStringEncodingGB_18030_2000: CFStringEncoding = 0x0632u
public const val kCFStringEncodingKSC_5601_87: CFStringEncoding = 0x0640u
public const val kCFStringEncodingKSC_5601_92_Johab: CFStringEncoding = 0x0641u
public const val kCFStringEncodingCNS_11643_92_P1: CFStringEncoding = 0x0651u
public const val kCFStringEncodingCNS_11643_92_P2: CFStringEncoding = 0x0652u
public const val kCFStringEncodingCNS_11643_92_P3: CFStringEncoding = 0x0653u
public const val kCFStringEncodingISO_2022_JP: CFStringEncoding = 0x0820u
public const val kCFStringEncodingISO_2022_JP_2: CFStringEncoding = 0x0821u
public const val kCFStringEncodingISO_2022_JP_1: CFStringEncoding = 0x0822u
public const val kCFStringEncodingISO_2022_JP_3: CFStringEncoding = 0x0823u
public const val kCFStringEncodingISO_2022_CN: CFStringEncoding = 0x0830u
public const val kCFStringEncodingISO_2022_CN_EXT: CFStringEncoding = 0x0831u
public const val kCFStringEncodingISO_2022_KR: CFStringEncoding = 0x0840u
public const val kCFStringEncodingEUC_JP: CFStringEncoding = 0x0920u
public const val kCFStringEncodingEUC_CN: CFStringEncoding = 0x0930u
public const val kCFStringEncodingEUC_TW: CFStringEncoding = 0x0931u
public const val kCFStringEncodingEUC_KR: CFStringEncoding = 0x0940u
public const val kCFStringEncodingShiftJIS: CFStringEncoding = 0x0A01u
public const val kCFStringEncodingKOI8_R: CFStringEncoding = 0x0A02u
public const val kCFStringEncodingBig5: CFStringEncoding = 0x0A03u
public const val kCFStringEncodingMacRomanLatin1: CFStringEncoding = 0x0A04u
public const val kCFStringEncodingHZ_GB_2312: CFStringEncoding = 0x0A05u
public const val kCFStringEncodingBig5_HKSCS_1999: CFStringEncoding = 0x0A06u
public const val kCFStringEncodingVISCII: CFStringEncoding = 0x0A07u
public const val kCFStringEncodingKOI8_U: CFStringEncoding = 0x0A08u
public const val kCFStringEncodingBig5_E: CFStringEncoding = 0x0A09u
public const val kCFStringEncodingNextStepJapanese: CFStringEncoding = 0x0B02u
public const val kCFStringEncodingEBCDIC_US: CFStringEncoding = 0x0C01u
public const val kCFStringEncodingEBCDIC_CP037: CFStringEncoding = 0x0C02u
public const val kCFStringEncodingUTF7: CFStringEncoding = 0x04000100u
public const val kCFStringEncodingUTF7_IMAP: CFStringEncoding = 0x0A10u

/** Deprecated alias for [kCFStringEncodingShiftJIS_X0213]. */
@Deprecated(
    "Use kCFStringEncodingShiftJIS_X0213 instead.",
    ReplaceWith("kCFStringEncodingShiftJIS_X0213"),
)
public const val kCFStringEncodingShiftJIS_X0213_00: CFStringEncoding = 0x0628u

public const val kCFStringEncodingInvalidId: UInt = 0xffffffffu

/**
 * `CFStringNormalizationForm` from CoreFoundation's `string.rs` (upstream
 * `pub type CFStringNormalizationForm = CFIndex`).
 */
public typealias CFStringNormalizationForm = CFIndex

public const val kCFStringNormalizationFormD: CFStringNormalizationForm = 0
public const val kCFStringNormalizationFormKD: CFStringNormalizationForm = 1
public const val kCFStringNormalizationFormC: CFStringNormalizationForm = 2
public const val kCFStringNormalizationFormKC: CFStringNormalizationForm = 3

public class __CFString
public typealias CFStringRef = __CFString
public typealias CFMutableStringRef = __CFString

public object CFString {
    public const val TYPE_ID: io.github.kotlinmania.corefoundationsys.base.CFTypeID = 35L

    public fun getTypeID(): io.github.kotlinmania.corefoundationsys.base.CFTypeID = TYPE_ID
}
