package com.xlix;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewApps;
    private AppAdapter appAdapter;
    private List<AppModel> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewApps = findViewById(R.id.recyclerViewApps);
        recyclerViewApps.setLayoutManager(new LinearLayoutManager(this));

        appList = getInstalledApps();
        appAdapter = new AppAdapter(this, appList);
        recyclerViewApps.setAdapter(appAdapter);
    }

    private List<AppModel> getInstalledApps() {
        List<AppModel> apps = new ArrayList<>();
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);

        for (ApplicationInfo packageInfo : packages) {
            // Hanya ambil user-installed apps
            if ((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                String appName = pm.getApplicationLabel(packageInfo).toString();
                String packageName = packageInfo.packageName;
                apps.add(new AppModel(appName, packageName, pm.getApplicationIcon(packageInfo)));
            }
        }
        return apps;
    }
}
