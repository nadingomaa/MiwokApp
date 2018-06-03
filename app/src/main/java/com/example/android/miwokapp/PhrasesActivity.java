package com.example.android.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener= new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();

            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        mAudioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("where are you going?","minto wuksus?",R.raw.phrase_where_are_you_going));
        words.add(new Word("what is your name?","tinne oyaase'na",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is....","oyaaset",R.raw.phrase_my_name_is));
        words.add(new Word("how are you feeling","michakses",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i am feeling good","kuich achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("are you coming?","eenes'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("yes,i am coming","hee'eenem",R.raw.phrase_yes_im_coming));
        words.add(new Word("i am coming","eenem",R.raw.phrase_im_coming));
        words.add(new Word("let's go","yoowuits",R.raw.phrase_lets_go));
        words.add(new Word("come here","anni'nem",R.raw.phrase_come_here));


        WordAdapter adapter=new WordAdapter(this,words);

        ListView listView =findViewById(R.id.listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word =words.get(position);
                releaseMediaPlayer();

                int  result= mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getAudioResourseId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }


}
