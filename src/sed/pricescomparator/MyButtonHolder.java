package sed.pricescomparator;

/*
 * 				MyButtonHolder butt = MyButtonHolder.getInstance(context);

				layout.addView(butt.getRoot());

 * */
import java.util.Date;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyButtonHolder {


	private TextView tv;
	private Button mButton;
	private String id = (""+new Date()).split("\\s")[3];
	private LinearLayout mRoot;
	
	
	
	private void init(){
		tv = ((TextView)mRoot.findViewById(R.id.mb_mtv));
		tv.setText("here2");
		
		mButton = (Button) mRoot.findViewById(R.id.mb_butt);
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tv.setText("-["+id+"]-> "+ new Date());
			}
		});
	}

	public static MyButtonHolder getInstance(Context context) {
		MyButtonHolder result = new MyButtonHolder();
		
		result.mRoot = (LinearLayout) ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.mb_, null);
		result.init();
		return result;
		
	}

	public View getRoot() {
		return mRoot;
	}

}
