package sed.pricescomparator;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main7PB extends LinearLayout {

	private TextView tv;
	int max = 0;
	int current = 0;

	public Main7PB(Context context) {
		super(context);
		tv = new TextView(context);
		updateInfo();
		this.addView(tv);
	}

	private void updateInfo() {
		tv.setText("["+current+"/"+max+"]");
	}

	public void setMax(int i) {
		max = i;
		updateInfo();
	}

	public void incrementProgressBy(int i) {
		current += i;
		updateInfo();
	}

	public void setProgress(int i) {
		current = i;
		updateInfo();
	}

	public int getProgress() {
		return current;
	}


}
