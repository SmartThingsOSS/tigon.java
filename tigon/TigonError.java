package com.smartthings.android.html.tigon;

/**
 * An error type definition for Tigon message handling.
 *
 * Created by jehyoung on 5/10/16.
 */

public enum TigonError {
    InvalidId,              // The message identifier was missing or malformed.
    InvalidPayLoad,         // The message payload was missing or malformed.
    UnexpectedMessageFormat // The message was unreadable.
}
