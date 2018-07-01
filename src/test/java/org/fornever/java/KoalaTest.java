package org.fornever.java;

import org.fornever.java.entities.MobilePhone;
import org.fornever.java.processors.KoalaProcessors;
import org.junit.Test;

public class KoalaTest {

    @Test
    public void test() {
        Koala<MobilePhone, String> koala = Koala.New(KoalaProcessors.New());
    }

}
