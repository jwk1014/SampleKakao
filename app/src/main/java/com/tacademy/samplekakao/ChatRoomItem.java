package com.tacademy.samplekakao;

import java.util.Date;

/**
 * Created by Tacademy on 2015-10-12.
 */
public class ChatRoomItem {
    int image_id;
    String title;
    int people;
    boolean mute;
    String talk_string;
    Date time;

    public ChatRoomItem(int image_id, String title, int people, boolean mute, String talk_string, Date time) {
        this.image_id = image_id;
        this.title = title;
        this.people = people;
        this.mute = mute;
        this.talk_string = talk_string;
        this.time = time;
    }
}
