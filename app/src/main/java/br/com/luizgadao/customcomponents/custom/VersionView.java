package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Luiz on 23/12/15.
 */
public class VersionView extends TextView {
    public VersionView(Context context) {
        super(context);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    private void setVersion(){
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            setText(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
