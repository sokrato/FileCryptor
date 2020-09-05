# FileCryptor

## Build
`./gradlew build`

This will produce a fat jar `build/libs/FileCryptor-0.1.0-all.jar`. 

## Usage
Set a password for this app before usage, either by means of system
env variable `export PASS=MyPass` or java property `java -DPASS=MyPass FileCryptor.jar`.

### Encrypt:

`java -jar build/libs/FileCryptor-0.1.0-all.jar enc file1`

This will produce a file `file1.enc`.

### Decrypt

`java -jar build/libs/FileCryptor-0.1.0-all.jar dec file1.enc`

This will decrypt `file1.enc` and name the output `file1`.