package io.github.sokrato.crypto;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface FileCodec {
    void encrypt(File src, File dst) throws IOException, GeneralSecurityException;

    void decrypt(File src, File dst) throws IOException, GeneralSecurityException;
}
