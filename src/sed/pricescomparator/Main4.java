package sed.pricescomparator;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main4 extends Activity{

	private LinearLayout layout;
	private TextView tv;
	private Main4 instance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("*** onCreate");
		
		instance = this;
		
		layout = new LinearLayout(this);
		setContentView(layout );
		layout.setOrientation(LinearLayout.VERTICAL);

		layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int x = layout.getWidth();
				int y = layout.getHeight();
				tv.setText(""+new Date()+"["+x+"]["+y+"]");
			}
		});

		tv =new TextView(this);
		layout.addView(tv);
		
		Button buttExplictCall = new Button(this);
		buttExplictCall.setText("explict call");
		layout.addView(buttExplictCall);
		buttExplictCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity( new Intent( instance, Main4Activity2.class));
				
			}
		});
		
		Button buttImplictCall = new Button(this);
		buttImplictCall.setText("HZ Call");
		layout.addView(buttImplictCall);
		buttImplictCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity( new Intent("sed.pricescomparator.M4ACT2"));
				
			}
		});

		
	}

	
//	@Override
//	protected void onStart() {
//		super.onStart();
//		System.out.println("*** onStart");
//	}
//
//	@Override
//	protected void onResume() {
//		super.onResume();
//		System.out.println("*** onResume");
//	}
//
//	
//	// inited and showed
//
//	
//	@Override
//	protected void onPause() {
//		super.onPause();
//		System.out.println("*** onPause");
//	}
//	
//
//	@Override
//	protected void onStop() {
//		super.onStop();
//		System.out.println("*** onStop");
//	}
//	
//	
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//		System.out.println("*** onDestroy");
//	}

}
