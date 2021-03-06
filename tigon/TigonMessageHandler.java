package com.smartthings.android.html.tigon;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import com.smartthings.android.html.MessageDelegator;

import timber.log.Timber;


public class TigonMessageHandler {

    private final Gson gson;
    private final MessageDelegator messageDelegator;
    private final TigonExecutor tigonExecutor;
    private TigonMessage tigonMessage;

    public TigonMessageHandler(@NonNull Gson gson,
                               @NonNull WebView webView,
                               @NonNull MessageDelegator messageDelegator) {
        this.messageDelegator = messageDelegator;
        this.gson = gson;

        tigonExecutor = new TigonExecutor(webView, gson);
    }

    /**
     * A way to receive messages sent from javascript.
     * You are expected to call `sendErrorResponse(_:error:)` or `sendSuccessResponse(_:response:)`
     * where appropriate.
     *
     * @param message A json object is composed with "id" and "payload" as keys.
     *                - id: the id of the message. Use this when calling `sendErrorResponse(_:error:)`
     *                or `sendSuccessResponse(_:response:)`.
     *                - payload: The object that was sent from javascript
     */
    @JavascriptInterface
    public void handleMessage(String message) {
        try {
            Timber.d("TigonMessage: %s", message);
            tigonMessage = gson.fromJson(message, TigonMessage.class);

            messageDelegator.handle(tigonMessage, tigonExecutor);

        } catch (JsonSyntaxException e) {
            // TODO: Error handling for this has not been defined yet. To be improved later.
            Timber.e("tigonMessage parsing error: %s", e.getMessage());
        }
    }

    /**
     * A way to receive errors when a `Tigon` fails to handle a message.
     *
     * @param error   The error that occurred while trying to parse the message.
     * @param message The message object that couldn't be parsed.
     */
    @JavascriptInterface
    public void messageError(TigonError error, Object message) {

        // TODO: There's no interface to receive a error response from Javascript.
        // This may be completed when we have the interface spec.
        Timber.d("messageError() error: %s, message: %s", error.toString(), message.toString());
    }

}
