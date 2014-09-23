package com.kogitune.minimumhome;

import com.squareup.otto.Bus;

/**
 * Created by takam on 2014/09/24.
 */
public class BusHolder {
    private static Bus sBus = new Bus();

    public static Bus get() {
        return sBus;
    }
}
