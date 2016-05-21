package com.hhxlab.poorhandler;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by HHX on 16/5/21.
 */
public class MessageQueue {
    ConcurrentLinkedQueue<Message> messageArrayList = new ConcurrentLinkedQueue<>();

    Message next() {
        Message message = null;

        message = messageArrayList.poll();

        return message;
    }

}
