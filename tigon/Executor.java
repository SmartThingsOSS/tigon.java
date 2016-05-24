package com.smartthings.android.html;


public interface Executor {

    /**
     * A way to respond to a message with an error.
     *
     * @param id The id of the original message
     * @param error The error to pass back to the sender of the original message
     */
    void sendErrorResponse(String id, Object error);

    /**
     * A way to respond to a message with a success object.
     *
     * @param id The id of the original message
     * @param response The success object to pass back to the sender of the original message
     */
    void sendSuccessResponse(String id, Object response);

    /**
     * A way to send a message to javascript.
     * @param message The message to send. This can be a stringified object.
     */
    void sendMessage(String message);

    /**
     * A way to stringify objects in a way for a specific Executor
     * @param object The object to stringify
     * @return The string object
     */
    String stringifyResponse(Object object);

    /**
     * A simplified wrapper for webView.loadUrl()
     *
     * @param script The script to be executed
     */
    void executeJavaScript(String script);
}