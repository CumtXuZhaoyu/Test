package com.itheima.mypractice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by XuZhaoyu on 2016/12/18.
 */

public class Utils {
    public static boolean isServiceRunning(Context context, Class clazz) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(1000);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            String serviceName = runningServiceInfo.service.getClassName();
            if (serviceName.equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }

    public static List<AppInfo> getAllAppInfo(Context context) {
        List<AppInfo> list = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (PackageInfo packageInfo : installedPackages) {
            AppInfo appInfo = new AppInfo();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            appInfo.appIcon = applicationInfo.loadIcon(packageManager);
            appInfo.appName = applicationInfo.loadLabel(packageManager).toString();
            appInfo.appPath = applicationInfo.sourceDir;
            appInfo.packageName = packageInfo.packageName;
            list.add(appInfo);
        }
        return list;
    }

    public static int getRunningProcessNum(Context context) {
        HashSet hashSet = new HashSet();
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.GET_ACTIVITIES | PackageManager.GET_PROVIDERS | PackageManager.GET_SERVICES | PackageManager.GET_RECEIVERS);
        for (PackageInfo packageInfo : installedPackages) {
            String processName = packageInfo.applicationInfo.processName;
            hashSet.add(processName);

            ActivityInfo[] activities = packageInfo.activities;
            for (ActivityInfo activityInfo : activities) {
                String activityProcessName = activityInfo.processName;
                hashSet.add(activityProcessName);
            }

            ProviderInfo[] providers = packageInfo.providers;
            for (ProviderInfo providerInfo : providers) {
                String providerProcessName = providerInfo.processName;
                hashSet.add(providerProcessName);
            }

            ActivityInfo[] receivers = packageInfo.receivers;
            for (ActivityInfo activityInfo : receivers) {
                String receiverProcessName = activityInfo.processName;
                hashSet.add(receiverProcessName);
            }

            ServiceInfo[] services = packageInfo.services;
            for (ServiceInfo serviceInfo : services) {
                String serviceProcessName = serviceInfo.processName;
                hashSet.add(serviceProcessName);
            }
        }

        return hashSet.size();
    }

    public static void listen(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:

                        break;
                    case TelephonyManager.CALL_STATE_RINGING:

                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:

                        break;
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
