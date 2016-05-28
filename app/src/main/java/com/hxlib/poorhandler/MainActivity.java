package com.hxlib.poorhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hhxlab.poorhandler.Looper;
import com.hhxlab.poorhandler.Message;
import com.hhxlab.poorhandler.PoorHandler;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SubThread subThread = new SubThread();
        subThread.start();
        subThread.getHandler().sendMesage(2);
        subThread.getHandler().sendMesage(0);
        subThread.getHandler().sendMesage(1);

    }

    class SubThread extends Thread {
        PoorHandler mPoorHandler;
        Object lock = new Object();
        public void run() {
            Looper.prepare();
            synchronized (lock) {
                mPoorHandler = new PoorHandler() {
                    @Override
                    public void handleMessage(Message e) {
                        if (e.what == 1)
                            System.out.println("e:get 1");
                        else
                            System.out.println("e:get is not 1, is " + e.what);
                    }
                };
                lock.notify();
            }
            Looper.loop();
        }
        public PoorHandler getHandler() {
            synchronized(lock) {
                while (mPoorHandler == null) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return mPoorHandler;
            }
        }
    }

}
