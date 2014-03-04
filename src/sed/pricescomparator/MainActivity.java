package sed.pricescomparator;

import java.util.Date;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	private MainActivity context;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.another);
		layout = (LinearLayout) findViewById(R.id.another);

		context = this;
		// View butt = getLayoutInflater().inflate(R.layout.my_button, layout,false);
		// View butt = findViewById(R.id.my_button);
		
		Button bb = (Button)findViewById(R.id.butt);
		bb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MyButtonHolder butt = MyButtonHolder.getInstance(context);

				layout.addView(butt.getRoot());

				
			}
		});
		
		
		ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar1);
		
		pb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((TextView)findViewById(R.id.mtv)).setText("["+new Date()+"]");
				//((Button)findViewById(R.id.mb_butt)).setText("["+new Date()+"]");
				
				layout.addView(new Some(getApplicationContext()));
				System.out.println("here");
			}
		});
		
		for (int i=0; i<3; i++){
			layout.addView(new Some(context));
			layout.addView(new Button(context));
			System.out.println("["+i+"]");
		}
		layout.addView(new Some(context));
		layout.addView(new Button(context));

	}

}
