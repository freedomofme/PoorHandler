package com.hhxlab.poorhandler;


/**
 * Created by HHX on 16/5/21.
 */
public final class Looper {
    static final ThreadLocal<Looper> mThreadLocal = new ThreadLocal<>();

    final MessageQueue mMessageQueue;

    public static void prepare() {
        mThreadLocal.set(new Looper());
    }

    private Looper() {
        mMessageQueue = new MessageQueue();
    }

    public static Looper myLooper() {
        return mThreadLocal.get();
    }

    public static void loop() {
        for(;;) {
            assert(myLooper() != null);
            Message message = myLooper().mMessageQueue.next();
            if (message != null) {
                message.target.dispatchMessage(message);
            }
        }
    }


}
