package com.simon.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    TextView updateTimeTv;
    Handler mUIHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //更新ui
            updateTimeTv.setText((String)msg.obj);
            //1秒后再次请求服务器，并更新数据
            timeMessagehandler.sendEmptyMessageAtTime(0,1000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTimeTv = (TextView)findViewById(R.id.tv);
        initThreadHandler();
    }

    HandlerThread handlerThread;
    Handler timeMessagehandler;
    private void initThreadHandler() {
        //构建HandlerThread
        handlerThread=new HandlerThread("updateTimeThread");
        //启动handler
        handlerThread.start();
        //构建子线程的handler对象
        timeMessagehandler=new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                //请求服务端时间
                try {
                    //模拟耗时请求
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //网络请求成功，通过主线程更新ui
                Message message=Message.obtain();
                message.obj= df.format(new Date());
                mUIHandler.sendMessage(message);
                System.out.println("handlerTimeMessage"+Thread.currentThread().getName());
            }
        };

        //向子线程发送消息，通知它发送网络请求
        timeMessagehandler.sendEmptyMessage(0);
    }


}
