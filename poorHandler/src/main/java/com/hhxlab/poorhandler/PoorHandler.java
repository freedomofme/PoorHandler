package com.hhxlab.poorhandler;

abstract class PoorHandler {
    abstract void handleMessage(Message e);

    public void dispatchMessage(Message e) {
        handleMessage(e);
    }

    public void sendMesage(int what) {
        Message message = obtainMessage();
        message.what = what;

        Looper.myLooper().mMessageQueue.messageArrayList.offer(message);

    }

    public Message obtainMessage() {
        return new Message();
    }


}

