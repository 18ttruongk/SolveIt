package tritruong.solveit;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * A pop up notification for when a user does not input all the necessary numbers
 */
public class Pop extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.50),(int) (height*.24));
    }
}
