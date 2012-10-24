package com.sm.app.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.sm.app.R;

public class TabsActivity extends TabActivity implements
		OnCheckedChangeListener {

	private TabHost mTabHost;
	private Intent mAIntent;
	private Intent mBIntent;
	private Intent mCIntent;
	private Intent mDIntent;
	private Intent mEIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tabs);

		this.mAIntent = new Intent(this, CommendationActivity.class);
		this.mBIntent = new Intent(this, SearchActivity.class);
		this.mCIntent = new Intent(this, CategoryActivity.class);
		this.mDIntent = new Intent(this, MyActivity.class);
		this.mEIntent = new Intent(this, MoreActivity.class);

		((RadioButton) findViewById(R.id.radio_commendation))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_search))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_category))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_my))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_more))
				.setOnCheckedChangeListener(this);

		setupIntent();
	}

	// according to radios to set tab tag
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.radio_commendation:
				this.mTabHost.setCurrentTabByTag("tab_commendation");
				break;
			case R.id.radio_search:
				this.mTabHost.setCurrentTabByTag("tab_search");
				break;
			case R.id.radio_category:
				this.mTabHost.setCurrentTabByTag("tab_category");
				break;
			case R.id.radio_my:
				this.mTabHost.setCurrentTabByTag("tab_my");
				break;
			case R.id.radio_more:
				this.mTabHost.setCurrentTabByTag("tab_more");
				break;

			}
		}

	}

	/**
	 * add tab for TabHost
	 */
	private void setupIntent() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;

		localTabHost.addTab(buildTabSpec("tab_commendation",
				R.string.radio_commendation, R.drawable.radio_commendation,
				this.mAIntent));

		localTabHost.addTab(buildTabSpec("tab_search", R.string.radio_search,
				R.drawable.radio_search, this.mBIntent));

		localTabHost.addTab(buildTabSpec("tab_category",
				R.string.radio_category, R.drawable.radio_category,
				this.mCIntent));

		localTabHost.addTab(buildTabSpec("tab_my", R.string.radio_my,
				R.drawable.radio_my, this.mDIntent));

		localTabHost.addTab(buildTabSpec("tab_more", R.string.radio_more,
				R.drawable.radio_more, this.mEIntent));

	}

	/**
	 * addTab(TabHost.TabSpec)
	 * 
	 * @param tag
	 * @param resLabel
	 * @param resIcon
	 * @param content
	 * @return
	 */
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		// ͨThrough the three methods to get
		return this.mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon))
				.setContent(content);
	}
}