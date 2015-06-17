package edu.fudan.hangout.util;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public class DaoResultWrapper {
    public static Object get(List list) {
        return list.isEmpty() ? null : list.get(0);
    }
}
