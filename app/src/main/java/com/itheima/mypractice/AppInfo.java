package com.itheima.mypractice;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by XuZhaoyu on 2016/12/18.
 */

public class AppInfo  implements Parcelable{
    public Drawable appIcon;
    public String appName;
    public String packageName;
    public String appPath;

    protected AppInfo(Parcel in) {
        appName = in.readString();
        packageName = in.readString();
        appPath = in.readString();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static final Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        @Override
        public AppInfo createFromParcel(Parcel in) {
            return new AppInfo(in);
        }

        @Override
        public AppInfo[] newArray(int size) {
            return new AppInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(appName);
        dest.writeString(packageName);
        dest.writeString(appPath);
    }
}
