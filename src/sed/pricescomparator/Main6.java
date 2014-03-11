package sed.pricescomparator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main6 extends Activity{

	private Main6 inst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inst = this;
		LinearLayout la = new LinearLayout(this);
		//la.setAlpha(0);
		//la.setBackgroundColor(null);
		setContentView(la);
		  
		Button btn = new Button(this);
		btn.setText("bye");
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				inst.finish();
			}
		});
		la.addView(btn);
		
	}

}
