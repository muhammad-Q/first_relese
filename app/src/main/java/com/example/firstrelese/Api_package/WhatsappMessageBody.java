package com.example.firstrelese.Api_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WhatsappMessageBody {

    @SerializedName("chatId")
    @Expose
    public String chatId;
    @SerializedName("body")
    @Expose
    public String body;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
