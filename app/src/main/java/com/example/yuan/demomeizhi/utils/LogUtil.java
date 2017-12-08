package com.example.yuan.demomeizhi.utils;

import android.util.Log;

/**
 * 打印日志
 * 6表示不输出日志
 * Created by yuan on 2017/12/8.
 */

public class LogUtil
{
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    public static int level = VERBOSE;

    public static void v(String tag, String msg)
    {
        if (level <= VERBOSE)
        {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg)
    {
        if (level <= DEBUG)
        {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg)
    {
        if (level <= INFO)
        {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg)
    {
        if (level <= WARN)
        {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg)
    {
        if (level <= ERROR)
        {
            Log.d(tag, msg);
        }
    }

}
