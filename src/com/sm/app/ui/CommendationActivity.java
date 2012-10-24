package com.sm.app.ui;

import com.sm.app.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CommendationActivity extends Activity {

	private ImageButton back;
	private TextView titleText;
	private Button handle;
	private Activity mActivity;
	
	back = (ImageButton) findViewById(R.id.back);
	titleText = (TextView) findViewById(R.id.titleText);
	handle = (Button) findViewById(R.id.titleRightButton);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commendation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
