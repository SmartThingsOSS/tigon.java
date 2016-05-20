package com.smartthings.android.html.tigon;

import com.smartthings.android.html.message.RequestMessage;
/**
 * A javascript request from tigon.js.
 * Note: The names of member variables are matched to the key names of json message.
 *
 * Created by jehyoung on 5/10/16.
 */

public class TigonMessage {

    private String id;
    private RequestMessage payload;

    public TigonMessage(String id, RequestMessage payload) {
        this.id = id;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public RequestMessage getPayload() {
        return payload;
    }
}
