package sed.pricescomparator;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main5 extends Activity{

	private Main5 inst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inst = this;
		LinearLayout la = new LinearLayout(this);
		setContentView(la);
		
		TextView tv = new TextView(inst);
		tv.setText((""+new Date()).split("\\s")[3] );
		la.addView(tv);
		
		Button btnNewActivity = new Button(this);
		btnNewActivity.setText("another Activity");
		btnNewActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(inst, Main5Act2.class),123);
			}
		});
		la.addView(btnNewActivity);
	
		Button btn = new Button(this);
		btn.setText("Phone Act");
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent();
			      //intent.setAction(Intent.ACTION_VIEW);
			      //intent.setData(Uri.parse("geo:55.754283,37.62002"));
			      //startActivity(intent);
				startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+79171020474")));
				}
		});
		la.addView(btn);

		
		Button btnBye = new Button(this);
		btnBye.setText("bye");
		btnBye.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				inst.finish();
			}
		});
		la.addView(btnBye);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intentData) {
		super.onActivityResult(requestCode, resultCode, intentData);
		System.out.println("HERE now ["+requestCode+"]["+resultCode+"]["+intentData.getExtras().getString("some")+"]");
	}

		
	

}
