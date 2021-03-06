package com.jaeyeonling.boilerplate.utils.random;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomUtils {

    private final TimeBasedGenerator timeBasedGenerator =
            Generators.timeBasedGenerator(EthernetAddress.constructMulticastAddress(ThreadLocalRandom.current()));
    private final AlphaNumeric alphaNumeric;

    //
    //
    //

    @Autowired
    private RandomUtils(final AlphaNumeric alphaNumeric) {
        this.alphaNumeric = alphaNumeric;
    }

    //
    //
    //

    public String getSecureString(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }

        return generateSecureString(length);
    }

    public String getTimebaseUUID() {
        return timeBasedGenerator.generate().toString().replaceAll("-", "");
    }

    //
    //
    //

    private String generateSecureString(final int length) {
        final var buff = new char[length];
        for (var index = 0; index < buff.length; index++) {
            buff[index] = alphaNumeric.randomChar();
        }

        return new String(buff);
    }
}
