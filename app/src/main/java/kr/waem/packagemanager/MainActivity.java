package kr.waem.packagemanager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvList = (TextView) findViewById(R.id.tv_list);
        getPackageList();
    }

    private void getPackageList(){
//        PackageManager pm = this.getPackageManager();
//
//        List<PackageInfo> packs =
////                pm.getInstalledPackages(PackageManager.GET_META_DATA);
//                pm.getInstalledPackages(PackageManager.PERMISSION_GRANTED);
//
//        for (PackageInfo pack : packs) {
//            Log.d("TAG", "| name    : " + pack.packageName);
//            Log.d("TAG", "| package : " + pack.packageName);
//            Log.d("TAG", "| version : " + pack.versionName);
//            tvList.setText(String.format("Package : %s", pack.packageName));
//        }

        PackageManager pkgm = getApplicationContext().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> AppInfos = pkgm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : AppInfos) {
            ActivityInfo ai = info.activityInfo;
            tvList.setText(String.format("Package : %s", ai.packageName));
            Log.i("GUNMAN: APP TITLE", ai.loadLabel(pkgm).toString());
//            Log.i("GUNMAN: APP Package Name", ai.packageName);
            Log.i("GUNMAN: APP Class Name", ai.name);
            int resId = ai.applicationInfo.icon; //App. Icon
        }
    }

//    private List<ResolveInfo> getPackageList() {
//
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        List<ResolveInfo> lst = getPackageManager().queryIntentActivities(intent, 0);
//        if (!lst.isEmpty()) {
//            for (ResolveInfo resolveInfo : lst) {
//                Log.d("Test", "New Launcher Found: " + resolveInfo.activityInfo.packageName);
//                tvList.setText("New Launcher Found: " + resolveInfo.activityInfo.packageName);
//            }
//        }
//        return lst;
//    }

//    private String[] getHomeLauncher(){
//        String[] HomeLauncher;
//        PackageManager pm =  getPackageManager();
//        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
//        homeIntent.addCategory(Intent.CATEGORY_HOME);
//
//        List<ResolveInfo> homeApps = pm.queryIntentActivities(homeIntent, PackageManager.GET_ACTIVITIES);
//        HomeLauncher = new String[homeApps.size()];
//        for(int i=0; i<homeApps.size(); i++){
//            ResolveInfo info = homeApps.get(i);
//            HomeLauncher[i] = info.activityInfo.packageName;
//        }
//        return HomeLauncher;
//    }
}
