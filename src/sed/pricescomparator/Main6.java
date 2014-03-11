package sed.pricescomparator;

import java.io.Serializable;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main6 extends Activity {

	private Main6 inst;
	private SomeS1 s1;
	private SomeS2 s2;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);
		inst = this;
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
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

//		 Object[] obj = (Object[]) getLastNonConfigurationInstance();
//		 if (obj != null && obj.length == 2){
//		 s1 = (SomeS1) obj[0];
//		 s2 = (SomeS2) obj[1]; 
//		 }
		if (state != null) {
			s1 = (SomeS1) state.getSerializable("s1");
			s2 = (SomeS2) state.getSerializable("s2");
		}
		s1 = (s1 == null ? new SomeS1() : s1);
		s2 = (s2 == null ? new SomeS2() : s2);

		TextView tvs1 = new TextView(this);
		tvs1.setText(s1.toString());
		tvs1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((TextView) v).setText(s1.incr().toString());
			}
		});
		la.addView(tvs1);

		TextView tvs2 = new TextView(this);
		tvs2.setText(s2.toString());
		tvs2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((TextView) v).setText(s2.incr().toString());
			}
		});
		la.addView(tvs2);
	}

//	 @Override
//	 @Deprecated
//	 public Object onRetainNonConfigurationInstance() {
//	 Object[] objs = new Object[2];
//	 objs[0] = s1;
//	 objs[1] = s2;
//	 return objs;
//	 }

	

	
	
	@Override
	protected void onSaveInstanceState(Bundle ost) {
		super.onSaveInstanceState(ost);
		System.out.println("HERE1");
		ost.putSerializable("s1", s1);
		ost.putSerializable("s2", s2);
		System.out.println("HERE2");
	}

	
	
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//		System.out.println("HERE DESTROY");
//	}



	@Override
	protected void onRestoreInstanceState(Bundle sis) {
		super.onRestoreInstanceState(sis);
		if (sis != null){
			s1 = (SomeS1) sis.getSerializable("s1");
			s2 = (SomeS2) sis.getSerializable("s2");
		}
	}



	class SomeS1 implements Serializable{
		private static final long serialVersionUID = 7624549534285865793L;
		String id = "some1 ";
		int cnt = 0;

		public SomeS1 incr() {
			this.cnt++;
			return this;
		}

		@Override
		public String toString() {
			return "[" + id + " " + cnt + "]";
		}
	}

	class SomeS2  implements Serializable{
		private static final long serialVersionUID = -5462642597414324743L;
		String id = "some2 ";
		int cnt = 0;

		public SomeS2 incr() {
			this.cnt++;
			return this;
		}

		@Override
		public String toString() {
			return "[" + id + " " + cnt + "]";
		}
	}
}