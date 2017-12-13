package com.svf.core.tools.logger;


/**
 * Created by stepanferubko
 */
public interface Logger {
    String getName();

    //INFO
    void info(String s, Object o);

    void info(Marker marker, String s);

    void info(String s, Object... objects);

    void info(Marker marker, String s, Throwable throwable);

    void info(String s, Throwable throwable);

    void info(String s);

    void info(Marker marker, String s, Object o, Object o1);

    void info(String s, Object o, Object o1);

    void info(Marker marker, String s, Object o);

    void info(Marker marker, String s, Object... objects);

    boolean isInfoEnabled(Marker marker);

    boolean isInfoEnabled();

    //WARN
    void warn(Marker marker, String s);

    void warn(Marker marker, String s, Throwable throwable);

    void warn(String s, Object... objects);

    void warn(String s);

    void warn(Marker marker, String s, Object... objects);

    void warn(String s, Object o);

    void warn(String s, Object o, Object o1);

    void warn(Marker marker, String s, Object o, Object o1);

    void warn(Marker marker, String s, Object o);

    void warn(String s, Throwable throwable);

    boolean isWarnEnabled(Marker marker);

    boolean isWarnEnabled();

    //error
    void error(String s, Throwable throwable);

    void error(Marker marker, String s, Object... objects);

    void error(Marker marker, String s, Object o);

    void error(Marker marker, String s);

    void error(String s);

    void error(String s, Object... objects);

    void error(Marker marker, String s, Object o, Object o1);

    void error(String s, Object o);

    void error(String s, Object o, Object o1);

    void error(Marker marker, String s, Throwable throwable);

    boolean isErrorEnabled(Marker marker);

    boolean isErrorEnabled();

    //DEBUG
    void debug(String s, Object o, Object o1);

    void debug(Marker marker, String s, Object o, Object o1);

    void debug(String s, Throwable throwable);

    void debug(String s, Object o);

    void debug(Marker marker, String s);

    void debug(String s, Object... objects);

    void debug(Marker marker, String s, Object... objects);

    void debug(Marker marker, String s, Throwable throwable);

    void debug(Marker marker, String s, Object o);

    void debug(String s);

    boolean isDebugEnabled(Marker marker);

    boolean isDebugEnabled();

    //TRACE
    void trace(String s, Object o, Object o1);

    void trace(String s, Throwable throwable);

    void trace(String s, Object o);

    void trace(Marker marker, String s, Object o, Object o1);

    void trace(Marker marker, String s, Object o);

    void trace(Marker marker, String s);

    void trace(String s, Object... objects);

    void trace(String s);

    void trace(Marker marker, String s, Object... objects);

    void trace(Marker marker, String s, Throwable throwable);

    boolean isTraceEnabled(Marker marker);

    boolean isTraceEnabled();
}
