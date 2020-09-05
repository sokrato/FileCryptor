package io.github.sokrato.crypto;

import org.encryptor4j.util.FileEncryptor;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * A simple wrapper around https://github.com/martinwithaar/Encryptor4j
 */
public class SimpleFileCodec implements FileCodec {
    private final FileEncryptor encryptor;

    public SimpleFileCodec(String password) {
        encryptor = new FileEncryptor(password);
    }

    @Override
    public void encrypt(File src, File dst) throws IOException, GeneralSecurityException {
        encryptor.encrypt(src, dst);
    }

    @Override
    public void decrypt(File src, File dst) throws IOException, GeneralSecurityException {
        encryptor.decrypt(src, dst);
    }
}
