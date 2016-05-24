package com.smartthings.android.html.tigon;


public enum TigonError {
    INVALID_ID,               // The message identifier was missing or malformed.
    INVALID_PAYLOAD,          // The message payload was missing or malformed.
    UNEXPECTED_MESSAGE_FORMAT // The message was unreadable.
}
