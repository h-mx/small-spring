package com.mx.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
