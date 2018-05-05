package org.fornever.java;

import org.fornever.java.entity.MobilePhone;
import org.fornever.java.processor.KoalaProcessors;
import org.junit.Test;

public class KoalaTest {

    @Test
    public void test() {
        Koala<MobilePhone, String> koala = Koala.New(KoalaProcessors.New());
    }

}
