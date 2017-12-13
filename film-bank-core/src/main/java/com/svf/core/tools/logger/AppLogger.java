package com.svf.core.tools.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

/**
 * Created by stepanferubko
 */
public class AppLogger implements Logger {
    private org.slf4j.Logger nativeLogger;

    private AppLogger(org.slf4j.Logger nativeLogger) {
        this.nativeLogger = nativeLogger;
    }

    public static Logger getLogger(Class type) {
        return new AppLogger(LoggerFactory.getLogger(type));
    }

    @Override
    public String getName() {
        return nativeLogger.getName();
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        nativeLogger.debug(s, o, o1);
    }

    @Override
    public boolean isErrorEnabled() {
        return nativeLogger.isErrorEnabled();
    }

    @Override
    public void info(String s, Object o) {
        nativeLogger.info(s, o);
    }

    @Override
    public void warn(Marker marker, String s) {
        nativeLogger.warn(MarkerFactory.getMarker(marker.getName()), s);
    }

    @Override
    public void error(String s, Throwable throwable) {
        nativeLogger.error(s, throwable);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        nativeLogger.warn(MarkerFactory.getMarker(marker.getName()), s, throwable);
    }

    @Override
    public void warn(String s, Object... objects) {
        nativeLogger.warn(s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        nativeLogger.debug(MarkerFactory.getMarker(marker.getName()), s, o, o1);
    }

    @Override
    public void warn(String s) {
        nativeLogger.warn(s);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return nativeLogger.isDebugEnabled(MarkerFactory.getMarker(marker.getName()));
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return nativeLogger.isInfoEnabled(MarkerFactory.getMarker(marker.getName()));
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        nativeLogger.trace(s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        nativeLogger.warn(MarkerFactory.getMarker(marker.getName()), s, objects);
    }

    @Override
    public boolean isDebugEnabled() {
        return nativeLogger.isDebugEnabled();
    }

    @Override
    public void warn(String s, Object o) {
        nativeLogger.warn(s, o);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        nativeLogger.error(MarkerFactory.getMarker(marker.getName()), s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        nativeLogger.trace(s, throwable);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        nativeLogger.debug(s, throwable);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        nativeLogger.error(MarkerFactory.getMarker(marker.getName()), s, o);
    }

    @Override
    public void debug(String s, Object o) {
        nativeLogger.debug(s, o);
    }

    @Override
    public boolean isTraceEnabled() {
        return nativeLogger.isTraceEnabled();
    }

    @Override
    public void debug(Marker marker, String s) {
        nativeLogger.debug(MarkerFactory.getMarker(marker.getName()), s);
    }

    @Override
    public boolean isWarnEnabled() {
        return nativeLogger.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return nativeLogger.isErrorEnabled(MarkerFactory.getMarker(marker.getName()));
    }

    @Override
    public void trace(String s, Object o) {
        nativeLogger.trace(s, o);
    }

    @Override
    public void error(Marker marker, String s) {
        nativeLogger.error(MarkerFactory.getMarker(marker.getName()), s);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        nativeLogger.trace(MarkerFactory.getMarker(marker.getName()), s, o, o1);
    }

    @Override
    public void info(Marker marker, String s) {
        nativeLogger.info(MarkerFactory.getMarker(marker.getName()), s);
    }

    @Override
    public void info(String s, Object... objects) {
        nativeLogger.info(s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        nativeLogger.info(MarkerFactory.getMarker(marker.getName()), s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return nativeLogger.isTraceEnabled(MarkerFactory.getMarker(marker.getName()));
    }

    @Override
    public void info(String s, Throwable throwable) {
        nativeLogger.info(s, throwable);
    }

    @Override
    public void info(String s) {
        nativeLogger.info(s);
    }

    @Override
    public void error(String s) {
        nativeLogger.error(s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        nativeLogger.trace(MarkerFactory.getMarker(marker.getName()), s, o);
    }

    @Override
    public void error(String s, Object... objects) {
        nativeLogger.error(s, objects);
    }

    @Override
    public void debug(String s, Object... objects) {
        nativeLogger.debug(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        nativeLogger.warn(s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        nativeLogger.error(MarkerFactory.getMarker(marker.getName()), s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        nativeLogger.debug(MarkerFactory.getMarker(marker.getName()), s, objects);
    }

    @Override
    public void trace(Marker marker, String s) {
        nativeLogger.trace(MarkerFactory.getMarker(marker.getName()), s);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        nativeLogger.debug(MarkerFactory.getMarker(marker.getName()), s, throwable);
    }

    @Override
    public void trace(String s, Object... objects) {
        nativeLogger.trace(s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        nativeLogger.debug(MarkerFactory.getMarker(marker.getName()), s, o);
    }

    @Override
    public void error(String s, Object o) {
        nativeLogger.error(s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        nativeLogger.info(MarkerFactory.getMarker(marker.getName()), s, o, o1);
    }

    @Override
    public void trace(String s) {
        nativeLogger.trace(s);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        nativeLogger.info(s, o, o1);
    }

    @Override
    public void error(String s, Object o, Object o1) {
        nativeLogger.error(s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        nativeLogger.trace(MarkerFactory.getMarker(marker.getName()), s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        nativeLogger.warn(MarkerFactory.getMarker(marker.getName()), s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        nativeLogger.trace(MarkerFactory.getMarker(marker.getName()), s, throwable);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        nativeLogger.warn(MarkerFactory.getMarker(marker.getName()), s, o);
    }

    @Override
    public boolean isInfoEnabled() {
        return nativeLogger.isInfoEnabled();
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        nativeLogger.error(MarkerFactory.getMarker(marker.getName()), s, throwable);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        nativeLogger.info(MarkerFactory.getMarker(marker.getName()), s, o);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return nativeLogger.isWarnEnabled(MarkerFactory.getMarker(marker.getName()));
    }

    @Override
    public void debug(String s) {
        nativeLogger.debug(s);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        nativeLogger.info(MarkerFactory.getMarker(marker.getName()), s, objects);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        nativeLogger.warn(s, throwable);
    }
}
