package com.redo.CRUD_Cliente.config;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomAccessFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return false;
    }
}
