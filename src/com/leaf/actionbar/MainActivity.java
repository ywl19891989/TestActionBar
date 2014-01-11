package com.leaf.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.leaf.actionbar.ActionBar.OnActionBarListener;
import com.leaf.actionbar.ActionBarItem.Type;

public class MainActivity extends Activity {

	private ActionBar mActionBar;
	private final Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ���type��normal�����
		mActionBar = (ActionBar) findViewById(R.id.gd_action_bar);
		// ����ұߵľ����item����ʵ��imagebutton
		// ���ڲ��Լ���װ��һЩtype������refresh��search����Ҫ����ֱ��ʹ�������õ�һЩͼƬ��Ϊimagebutton��src
		// �����Ǹ�imagebutton��id��������values/ids.xml�ж���
		// ˢ�¸�����type������һ��������һ��imagebutton������һ��progressbar������ɿ���
		mActionBar.addItem(Type.Refresh, R.id.action_bar_refresh);
		mActionBar.addItem(Type.Search, R.id.action_bar_search);
		// ��Ҳ���԰�������һ���Լ����һ��item�������Լ���ͼƬ
		mActionBar.addItem(
				mActionBar.newActionBarItem(NormalActionBarItem.class)
						.setDrawable(R.drawable.gd_action_bar_eye)
						.setContentDescription("view"), R.id.action_bar_view);
		// ��item��imagebutton��Ӽ����¼�
		mActionBar.setOnActionBarListener(new OnActionBarListener() {

			@Override
			public void onActionBarItemClicked(int position) {

				if (position == ActionBar.OnActionBarListener.HOME_ITEM) {

					// ������ߵ���ҳ��ťʱ�������Ĳ���
					Toast.makeText(MainActivity.this, "home or back",
							Toast.LENGTH_SHORT).show();
					return;

				}

				final ActionBarItem item = mActionBar.getItem(position);

				switch (item.getItemId()) {
				case R.id.action_bar_refresh:
					if (item instanceof LoaderActionBarItem) {

						mHandler.postDelayed(new Runnable() {
							@Override
							public void run() {
								// ͨ�����������������ʾ�������Ǹ�progressbar
								((LoaderActionBarItem) item).setLoading(false);
							}
						}, 2000);
					}

					Toast.makeText(MainActivity.this, "refresh",
							Toast.LENGTH_SHORT).show();
					break;

				case R.id.action_bar_search:

					// �����Ĳ���
					Toast.makeText(MainActivity.this, "search",
							Toast.LENGTH_SHORT).show();
					break;

				case R.id.action_bar_view:

					// �����Ĳ���
					Toast.makeText(MainActivity.this, "view",
							Toast.LENGTH_SHORT).show();
					break;

				}
			}
		});
	}

}
