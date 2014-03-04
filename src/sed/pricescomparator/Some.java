package sed.pricescomparator;

import java.util.Date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Some extends RelativeLayout  {

	//private LinearLayout ll;
	private String id = ""+System.currentTimeMillis();//(""+new Date()).split("\\s")[3];
	
	public Some(Context context) {
		super(context);
		System.out.println("uno "+id);
		//((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.some, this);
//		((LayoutInflater)  getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.some, this);
//		TextView tv = (TextView)findViewById(R.id.some_tv);
//		tv.setText(">> "+id);
//		this.addView(new Button(getContext()));
		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.some, this);
		
	}

	public Some(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		System.out.println("dos "+id);
		((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.some, this);
	}

	public Some(Context context, AttributeSet attrs) {
		super(context, attrs);
		System.out.println("tres"+id);
		((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.some, this);
	}


}
