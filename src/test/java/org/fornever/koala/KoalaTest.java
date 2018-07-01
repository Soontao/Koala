package org.fornever.koala;

import org.fornever.koala.entities.MobilePhone;
import org.fornever.koala.processors.KoalaProcessors;
import org.junit.Test;

public class KoalaTest {

    @Test
    public void test() {
        Koala<MobilePhone, String> koala = Koala.New(KoalaProcessors.New());
    }

}
