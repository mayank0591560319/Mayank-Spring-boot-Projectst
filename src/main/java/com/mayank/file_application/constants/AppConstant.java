package com.mayank.file_application.constants;

import java.util.HashMap;
import java.util.Map;

public class AppConstant {
    public static final Map<String, Object> MAX_FILE_EXCEEDED_LIMIT;

    static {
        MAX_FILE_EXCEEDED_LIMIT = new HashMap<>();
        MAX_FILE_EXCEEDED_LIMIT.put("error", "File limit is exceeded");
        MAX_FILE_EXCEEDED_LIMIT.put("responseCode", 400);
    }

}
