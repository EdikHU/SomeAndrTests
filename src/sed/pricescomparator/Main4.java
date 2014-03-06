package sed.pricescomparator;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main4 extends Activity{

	private LinearLayout layout;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		layout = new LinearLayout(this);
		setContentView(layout );

		layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int x = layout.getWidth();
				int y = layout.getHeight();
				tv.setText("["+x+"]["+y+"]");
			}
		});

		tv =new TextView(this);
		layout.addView(tv);
	}
	
	

}
