package tritruong.solveit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private double num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12;
    private double[][] mat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button solveBtn = (Button) findViewById(R.id.solveBtn);
        solveBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText var_1 = (EditText) findViewById(R.id.var_1);
                EditText var_2 = (EditText) findViewById(R.id.var_2);
                EditText var_3= (EditText) findViewById(R.id.var_3);
                EditText var_4 = (EditText) findViewById(R.id.var_4);
                EditText var_5 = (EditText) findViewById(R.id.var_5);
                EditText var_6 = (EditText) findViewById(R.id.var_6);
                EditText var_7 = (EditText) findViewById(R.id.var_7);
                EditText var_8 = (EditText) findViewById(R.id.var_8);
                EditText var_9 = (EditText) findViewById(R.id.var_9);
                EditText var_10 = (EditText) findViewById(R.id.var_10);
                EditText var_11 = (EditText) findViewById(R.id.var_11);
                EditText var_12 = (EditText) findViewById(R.id.var_12);

                TextView ans_x = (TextView) findViewById(R.id.ans_x);
                TextView ans_y = (TextView) findViewById(R.id.ans_y);
                TextView ans_z = (TextView) findViewById(R.id.ans_z);

                if( var_1.getText().toString().equals("")
                        || var_2.getText().toString().equals("")
                        || var_3.getText().toString().equals("")
                        || var_4.getText().toString().equals("")
                        || var_5.getText().toString().equals("")
                        || var_6.getText().toString().equals("")
                        || var_7.getText().toString().equals("")
                        || var_8.getText().toString().equals("")
                        || var_9.getText().toString().equals("")
                        || var_10.getText().toString().equals("")
                        || var_11.getText().toString().equals("")
                        || var_12.getText().toString().equals("")){
                    //setNull(ans_x, ans_y, ans_z);
                    startActivity(new Intent(SecondActivity.this, Pop.class));
                }
                else {
                    num1 = Double.parseDouble(var_1.getText().toString());
                    num2 = Double.parseDouble(var_2.getText().toString());
                    num3 = Double.parseDouble(var_3.getText().toString());
                    num4 = Double.parseDouble(var_4.getText().toString());
                    num5 = Double.parseDouble(var_5.getText().toString());
                    num6 = Double.parseDouble(var_6.getText().toString());
                    num7 = Double.parseDouble(var_7.getText().toString());
                    num8 = Double.parseDouble(var_8.getText().toString());
                    num9 = Double.parseDouble(var_9.getText().toString());
                    num10 = Double.parseDouble(var_10.getText().toString());
                    num11 = Double.parseDouble(var_11.getText().toString());
                    num12 = Double.parseDouble(var_12.getText().toString());

                    final double[] answers = solve(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12);
                    ans_x.setText(answers[0] + "");
                    ans_y.setText(answers[1] + "");
                    ans_z.setText(answers[2] + "");
                }
            }
            public void setNull( TextView a, TextView b, TextView c){
                    a.setText("null");
                    b.setText("null");
                    c.setText("null");
                }
            public double[] solve(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8, double num9, double num10, double num11, double num12 ){
                mat = new double[3][4];
                mat[0][0] = num1;
                mat[0][1] = num2;
                mat[0][2] = num3;
                mat[0][3] = num4;
                mat[1][0] = num5;
                mat[1][1] = num6;
                mat[1][2] = num7;
                mat[1][3] = num8;
                mat[2][0] = num9;
                mat[2][1] = num10;
                mat[2][2] = num11;
                mat[2][3] = num12;
                matTransformation();
                double[] ans = new double[3];
                ans = calculator();
                return ans;

            }
            /*
             * add 2 rows to create 0's in rows 2 and 3
             */
            public void modify(double R1, double R2, int row1, int row2  ){
                for(int i = 0; i < 4; i++){
                    mat[row2][i] = (-R2)*mat[row1][i] + R1*mat[row2][i];
                }
            }
            /*
             * transforms matrix
             */
            public void matTransformation(){
                modify(mat[0][0], mat[1][0], 0, 1);
                modify(mat[0][0], mat[2][0], 0, 2);
                modify(mat[1][1], mat[2][1], 1, 2);
            }
            /*
             * performs backward substitutions
             */
            public double[] calculator(){
                double[] ans = new double[3];
                double z; double y; double x;
                z = mat[2][3]/mat[2][2];
                y = (mat[1][3]-(mat[1][2]*z))/mat[1][1];
                x = (mat[0][3] - (mat[0][2]*z) - (mat[0][1]*y) )/mat[0][0];
                ans[0] = x;
                ans[1] = y;
                ans[2] = z;
                return ans;
            }
         });
    }
}
