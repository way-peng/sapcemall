package com.sm.app.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

import com.sm.app.R;

public class MoreAboutActivity extends BaseActivity {

	private TextView mVersion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_about);

		// 获取客户端版本信息
		try {
			PackageInfo info = getPackageManager().getPackageInfo(
					getPackageName(), 0);
			mVersion = (TextView) findViewById(R.id.more_about_version);
			mVersion.setText("版本：" + info.versionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace(System.err);
		}

	}
}
