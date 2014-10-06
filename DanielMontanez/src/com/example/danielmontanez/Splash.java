package com.example.danielmontanez;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity{
	
	private static int SPLASH_TIMER = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_splash);
		
		MediaPlayer mPlayer;
		mPlayer= MediaPlayer.create(this, R.raw.splash_wav);
		        mPlayer.start();
		
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent i = new Intent(Splash.this, Main.class);
				startActivity(i);
				finish();
			}
			
		}, SPLASH_TIMER);
	}

}
