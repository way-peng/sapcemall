package com.sm.app.common;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sm.app.R;

public class TitleView extends Activity{
	private ImageButton back;
	private TextView titleText;
	private Button handle;
	private Activity mActivity;
	
	back = (ImageButton) findViewById(R.id.back);
	titleText = (TextView) findViewById(R.id.titleText);
	handle = (Button) findViewById(R.id.titleRightButton);
	private void setView(Activity mActivity) {
		

		switch (mActivity) {
		case VIEWSWITCH_TYPE_DETAIL:

			mDetail.setEnabled(false);
			mCommentList.setEnabled(true);
			mHeadTitle.setText(R.string.blog_detail_head_title);
			mViewSwitcher.setDisplayedChild(0);
			break;
		case VIEWSWITCH_TYPE_COMMENTS:
			mDetail.setEnabled(true);
			mCommentList.setEnabled(false);
			mHeadTitle.setText(R.string.comment_list_head_title);
			mViewSwitcher.setDisplayedChild(1);
			break;
		}
	}


}
