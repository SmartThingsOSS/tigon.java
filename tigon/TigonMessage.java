package com.smartthings.android.html.tigon;

import com.smartthings.android.html.message.RequestMessage;


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
