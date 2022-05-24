package com.example.coproject.logging;

public interface ILogger {
    void write(long number);
    void write(String s);
    void write(Object ... values);
    void close();
    void writeTime(String string,long value,Units unit);
}
