package edu.fudan.hangout.util;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public class QueryListWrapper {
    public static Object from(List list) {
        return list.isEmpty() ? null : list.get(0);
    }
}
