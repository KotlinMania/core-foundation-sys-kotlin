// port-lint: source user_notification.rs
package io.github.kotlinmania.corefoundationsys.usernotification

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFUserNotification
public typealias CFUserNotificationRef = __CFUserNotification

public typealias CFUserNotificationCallBack = (userNotification: CFUserNotificationRef?, responseFlags: CFOptionFlags) -> Unit

public const val kCFUserNotificationStopAlertLevel: CFOptionFlags = 0L
public const val kCFUserNotificationNoteAlertLevel: CFOptionFlags = 1L
public const val kCFUserNotificationCautionAlertLevel: CFOptionFlags = 2L
public const val kCFUserNotificationPlainAlertLevel: CFOptionFlags = 3L

public const val kCFUserNotificationDefaultResponse: CFOptionFlags = 0L
public const val kCFUserNotificationAlternateResponse: CFOptionFlags = 1L
public const val kCFUserNotificationOtherResponse: CFOptionFlags = 2L
public const val kCFUserNotificationCancelResponse: CFOptionFlags = 3L

public const val kCFUserNotificationNoDefaultButtonFlag: CFOptionFlags = 1L shl 5
public const val kCFUserNotificationUseRadioButtonsFlag: CFOptionFlags = 1L shl 6

public fun cfUserNotificationCheckBoxChecked(i: CFIndex): CFOptionFlags = (1L shl (8 + i))
public fun cfUserNotificationSecureTextField(i: CFIndex): CFOptionFlags = (1L shl (16 + i))
public fun cfUserNotificationPopUpSelection(n: CFIndex): CFOptionFlags = (n.toLong() shl 24)

public object CFUserNotification {
    public const val TYPE_ID: CFTypeID = 57L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val ICON_URL_KEY: String = "kCFUserNotificationIconURLKey"
    public const val SOUND_URL_KEY: String = "kCFUserNotificationSoundURLKey"
    public const val LOCALIZATION_URL_KEY: String = "kCFUserNotificationLocalizationURLKey"
    public const val ALERT_HEADER_KEY: String = "kCFUserNotificationAlertHeaderKey"
    public const val ALERT_MESSAGE_KEY: String = "kCFUserNotificationAlertMessageKey"
    public const val DEFAULT_BUTTON_TITLE_KEY: String = "kCFUserNotificationDefaultButtonTitleKey"
    public const val ALTERNATE_BUTTON_TITLE_KEY: String = "kCFUserNotificationAlternateButtonTitleKey"
    public const val OTHER_BUTTON_TITLE_KEY: String = "kCFUserNotificationOtherButtonTitleKey"
    public const val PROGRESS_INDICATOR_VALUE_KEY: String = "kCFUserNotificationProgressIndicatorValueKey"
    public const val POP_UP_TITLES_KEY: String = "kCFUserNotificationPopUpTitlesKey"
    public const val TEXT_FIELD_TITLES_KEY: String = "kCFUserNotificationTextFieldTitlesKey"
    public const val CHECK_BOX_TITLES_KEY: String = "kCFUserNotificationCheckBoxTitlesKey"
    public const val TEXT_FIELD_VALUES_KEY: String = "kCFUserNotificationTextFieldValuesKey"
    public const val POP_UP_SELECTION_KEY: String = "kCFUserNotificationPopUpSelectionKey"
    public const val ALERT_TOP_MOST_KEY: String = "kCFUserNotificationAlertTopMostKey"
    public const val KEYBOARD_TYPES_KEY: String = "kCFUserNotificationKeyboardTypesKey"
}
