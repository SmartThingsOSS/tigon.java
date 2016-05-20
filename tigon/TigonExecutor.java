package com.smartthings.android.html.tigon;

import android.webkit.WebView;

import com.google.gson.Gson;

import com.smartthings.android.html.Executor;

import timber.log.Timber;
/**
 * TigonExecutor provides a simple interface for interacting with Javascript. It assumes Tigon.js is
 * included in the HTML.
 *
 * Created by jehyoung on 5/10/16.
 */
public class TigonExecutor implements Executor {

    private static final String JAVASCRIPT_URL_PREFIX = "javascript:%s";
    private WebView webView;
    private Gson gson;

    public TigonExecutor(WebView webView, Gson gson) {
        this.webView = webView;
        this.gson = gson;
    }

    public void sendErrorResponse(String id, Object error) {
        String responseString = stringifyResponse(error);
        String script = "tigon.receivedErrorResponse('" + id + "', " + responseString + ")";
        executeJavaScript(script);
    }

    public void sendSuccessResponse(String id, Object response) {
        String responseString = stringifyResponse(response);
        String script = "tigon.receivedSuccessResponse('" + id + "', " + responseString + ")";
        executeJavaScript(script);
    }

    public void sendMessage(String message) {
        executeJavaScript(String.format("tigon.receivedMessage(%s)", message));
    }

    public String stringifyResponse(Object object) {
        String jsonResponse = "{}";

        try {
            jsonResponse = this.gson.toJson(object);

        } catch (Exception e) {
            Timber.e("object.toString() failed with error: %s", e.getMessage());
        }
        return jsonResponse;
    }

    public void executeJavaScript(String script) {
        Timber.d("%s", String.format(JAVASCRIPT_URL_PREFIX, script));
        webView.loadUrl(String.format(JAVASCRIPT_URL_PREFIX, script));
    }
}
