package com.example.administrator.live.Utils.First_handUtils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @类的用途:
 * @作者: 任正威
 * @date: 2017/5/25.
 */

public class DeviceUtil {
    /**
     * 获得设备唯一标识
     *
     * @param context
     * @return
     */
    public static String getLocaldeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null
                || deviceId.trim().length() == 0) {
            deviceId = String.valueOf(System
                    .currentTimeMillis());
        }
        return deviceId;
    }
}
