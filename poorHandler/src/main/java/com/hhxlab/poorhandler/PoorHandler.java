package com.hhxlab.poorhandler;

public class PoorHandler {
    public PoorHandler() {
        Looper mLooper = Looper.myLooper();
        messageQueue = mLooper.mMessageQueue;
    }

    public PoorHandler(MessageQueue mMessageQueue) {
        messageQueue = mMessageQueue;
    }

    public void handleMessage(Message e) {
    };

    final MessageQueue messageQueue;

    public void dispatchMessage(Message e) {
        handleMessage(e);
    }

    public void sendMesage(int what) {
        Message message = obtainMessage();
        message.what = what;

        try {
            messageQueue.messageArrayList.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Message obtainMessage() {
        Message temp = new Message();
        temp.target = this;
        return temp;
    }


}

