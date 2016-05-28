package com.hhxlab.poorhandler;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by HHX on 16/5/21.
 */
public class MessageQueue {
    LinkedBlockingQueue<Message> messageArrayList = new LinkedBlockingQueue<Message>();

    Message next() {
        Message message = null;

        try {
            message = messageArrayList.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return message;
    }

}
