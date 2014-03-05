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
		
		Button bb = (Button)findViewById(R.id.butt);
		bb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View ll = Some2.getInstance(context);
				layout.addView(ll);
				System.out.println("button here");
			}
		});
		
		
		ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar1);
		pb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Some2.setTV( (""+new Date()).split("\\s")[3]  );
				System.out.println("pb here "+v.getId()+" "+layout.getId());
				for (int i=0;i< layout.getChildCount();i++){
					System.out.println("--> "+i);
					if (Some2.class.equals(layout.getChildAt(i).getTag() ) ){
						((TextView)layout.getChildAt(i).findViewById(R.id.some_tv)).setText((""+new Date()).split("\\s")[3] );
						System.out.println("finded");
					}
				}
			}
		});
		

	}

}
