package com.javayhu.kiss.utils;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 *
 * author: Blankj & Javayhu
 * original: https://github.com/Blankj/AndroidUtilCode
 * time  : 16/11/01
 * desc  : Handler相关工具类
 *
 */
public class HandlerUtils {

    private HandlerUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static class HandlerHolder extends Handler {
        WeakReference<OnReceiveMessageListener> mListenerWeakReference;

        /**
         * 使用必读：推荐在Activity或者Activity内部持有类中实现该接口，不要使用匿名类，可能会被GC
         *
         * @param listener 收到消息回调接口
         */
        public HandlerHolder(OnReceiveMessageListener listener) {
            mListenerWeakReference = new WeakReference<>(listener);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mListenerWeakReference != null && mListenerWeakReference.get() != null) {
                mListenerWeakReference.get().handlerMessage(msg);
            }
        }
    }

    /**
     * 收到消息回调接口
     */
    public interface OnReceiveMessageListener {
        void handlerMessage(Message msg);
    }
}

//usage
//activity去实现OnReceiveMessageListener接口
//再定义变量HandlerHolder变量，将activity自己传入进来
//发送message使用HandlerHolder变量，最终将由activity实现的handlerMessage方法来处理消息