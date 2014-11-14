package com.example.myfirst;

import com.example.myfirst.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// declare variables and assign the views from layouts
		TextView userName = (TextView) findViewById(R.id.userName);
		TextView passWord = (TextView) findViewById(R.id.passWord);
		final TextView error = (TextView) findViewById(R.id.error);
		final EditText userName_txt = (EditText) findViewById(R.id.editText1);
		final EditText passWord_txt = (EditText) findViewById(R.id.editText2);
		final Button logIn_btn = (Button) findViewById(R.id.LogIn);
		Button Reg_btn = (Button) findViewById(R.id.RgrBtn);
		userName.setText("Username");
		passWord.setText("password");
		// Creating database and table

		final MySQLiteHandler db = new MySQLiteHandler(this);

		// add user

		Reg_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				final String username = userName_txt.getText().toString();
				final String password = passWord_txt.getText().toString();
				boolean i = db.addUser(username, password);
				if (i) {
					// Toast.makeText(MembersActivity.this,
					// "You have successfully registered",Toast.LENGTH_LONG).show();
					error.setText("registered");
				} else {
					error.setText("not registered");
				}
			}

		});

		logIn_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// the Button is clicked , lets login

				final String username = userName_txt.getText().toString();
				final String password = passWord_txt.getText().toString();
				if (username.length() > 0 && password.length() > 0) {
					boolean k=db.Login(username, password);
					if (k) {
						error.setText("login is done");
						
					} else {
						error.setText("invalid username and password");
					}
				}

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
