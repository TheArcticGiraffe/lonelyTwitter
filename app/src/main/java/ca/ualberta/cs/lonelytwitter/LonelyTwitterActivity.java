/*
 * Copyright 2019 Seth Karstad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Contains Tweet objects, and allows a user to create Tweets, or completely erase all Tweets.
 * @author Seth Karstad
 * @see Activity
 * @see Tweet
 * @version 1.0
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>(0);
	private ArrayAdapter<Tweet> adapter;

	/**
	 *Called when the activity is first created.
	 * @since 1.0
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton  = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Determines what happens when the saveButton is clicked.
			 * @param v The view the app is currently in
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new ImportantTweet(text);

				tweetList.add(tweet);

				adapter.notifyDataSetChanged();


				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Determines what happens when the saveButton is clicked.
			 * @param v The view the app is currently in
			 */

			public void onClick(View v) {
				setResult(RESULT_OK);



				tweetList.clear();

				adapter.notifyDataSetChanged();


				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

	}

	/**
	 * Performs all the functions needed to start the application.
	 * @since 1.0
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads the Tweets to the backend. The Gson file stored in memory is retrieved, and converted
	 * into an ArrayList of Tweet objects.
	 * @return tweets.toArray(new String[tweets.size()]) The ArrayList of Tweets
	 * @see Tweet
	 * @since 1.0
	 */
	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			/* FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}
			*/

			FileReader in = new FileReader(new File(getFilesDir(), FILENAME));

			Gson gson = new Gson();

			// taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Jan 19

			Type type = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();

			this.tweetList = gson.fromJson(in, type);
			in.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}


	/**
	 * Saves the Tweets to the backend. The ArrayList of Tweets is converted to a Gson object, and
	 * stored in memory.
	 * @see Tweet
	 * @since 1.0
	 */
	private void saveInFile() {
		try {
			//FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
			//fos.write(new String(date.toString() + " | " + text).getBytes());
			//fos.close();

			FileWriter out = new FileWriter(new File(getFilesDir(),FILENAME));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);
			out.close();

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//testing github