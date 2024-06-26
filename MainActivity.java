package com.example.musicplayer;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity {
 MediaPlayer m;
 public void play(View view){
 m.start();
 }
 public void pause(View view){
 m.pause();
 }
 public void stop(View view){
 m.stop();
 }
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 m=MediaPlayer.create(this,R.raw.song);
 final AudioManager 
aud=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
 int max=aud.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
 int pro=aud.getStreamVolume(AudioManager.STREAM_MUSIC);
 SeekBar s=findViewById(R.id.sb1);
 s.setMax(max);
 s.setProgress(pro);
 s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() 
{
 @Override
 public void onProgressChanged(SeekBar seekBar, int progress, 
boolean fromUser) {
 aud.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
 }
 @Override
 public void onStartTrackingTouch(SeekBar seekBar) {
 }
 @Override
 public void onStopTrackingTouch(SeekBar seekBar) {

 }
 }); }
}
