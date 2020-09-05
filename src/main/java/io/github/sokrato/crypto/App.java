package io.github.sokrato.crypto;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String pass = guess("PASS", "s3cre1");
        App app = new App(new SimpleFileCodec(pass));

        try {
            app.run(args);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    private FileCodec crypto;

    public App(FileCodec crypto) {
        this.crypto = crypto;
    }

    public void run(String[] args) throws GeneralSecurityException, IOException {
        if (args.length <= 1) {
            help();
            return;
        }

        String cmd = args[0];
        String[] filenames = Arrays.copyOfRange(args, 1, args.length);
        if ("enc".equals(cmd))
            encrypt(filenames);
        else if ("dec".equals(cmd))
            decrypt(filenames);
        else
            help();
    }

    private void help() {
        System.out.println("enc filenames");
        System.out.println("dec filenames");
    }

    private void encrypt(String[] filenames) throws GeneralSecurityException, IOException {
        for (String filename : filenames) {
            String dstName = filename + ".enc";
            File dst = new File(dstName);
            if (dst.exists())
                throw new IllegalArgumentException("dst exist for: " + filename);
            crypto.encrypt(new File(filename), dst);
        }
    }

    private void decrypt(String[] filenames) throws GeneralSecurityException, IOException {
        for (String filename : filenames) {
            if (!filename.endsWith(".enc"))
                throw new IllegalArgumentException("filename for decryption must ends with .enc");

            String dstName = filename.substring(0, filename.length() - 4);
            File dst = new File(dstName);
            if (dst.exists())
                throw new IllegalArgumentException("dst file exists: " + dstName);

            crypto.decrypt(new File(filename), dst);
        }
    }

    private static String guess(String key, String defaultValue) {
        List<String> choices = Arrays.asList(
                System.getProperty(key),
                System.getenv(key)
        );
        for (String value : choices) {
            if (!(value == null || value.isEmpty()))
                return value;
        }

        return defaultValue;
    }
}
