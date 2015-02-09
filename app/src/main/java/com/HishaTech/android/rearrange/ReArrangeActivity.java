package com.HishaTech.android.rearrange;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.HishaTech.android.rearrange.db.model.Words;
import com.HishaTech.android.rearrange.db.table.table_Words;

/**
 * Created by smithkev on 2/9/2015.
 */
public class ReArrangeActivity extends Activity {

    //http://www.vogella.com/tutorials/AndroidDragAndDrop/article.html

    GridLayout gridWord;
    LinearLayout LetterOne, LetterTwo, LetterThree, LetterFour, LetterFive,
            LetterSix, LetterSeven, LetterEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rearrange);

        gridWord = (GridLayout) findViewById(R.id.gridWord);
        LetterOne = (LinearLayout) findViewById(R.id.LetterOne);
        LetterTwo = (LinearLayout) findViewById(R.id.LetterTwo);
        LetterThree = (LinearLayout) findViewById(R.id.LetterThree);
        LetterFour = (LinearLayout) findViewById(R.id.LetterFour);
        LetterFive = (LinearLayout) findViewById(R.id.LetterFive);
        LetterSix = (LinearLayout) findViewById(R.id.LetterSix);
        LetterSeven = (LinearLayout) findViewById(R.id.LetterSeven);
        LetterEight = (LinearLayout) findViewById(R.id.LetterEight);


        Words words = new Words();

        //TODO: add code to randomize lettercount based on preference.
        words = table_Words.getRandomWord(this, 0);

        Integer letterCount = words.getLetterCount();
        gridWord.setColumnCount(letterCount);

        if (letterCount == 4) {

            LetterOne.setOnDragListener(new MyDragListener());
            LetterTwo.setOnDragListener(new MyDragListener());
            LetterThree.setOnDragListener(new MyDragListener());
            LetterFour.setOnDragListener(new MyDragListener());
            LetterFive.setVisibility(View.GONE);
            LetterSix.setVisibility(View.GONE);
            LetterSeven.setVisibility(View.GONE);
            LetterEight.setVisibility(View.GONE);

        } else if (letterCount == 5) {

            LetterOne.setOnDragListener(new MyDragListener());
            LetterTwo.setOnDragListener(new MyDragListener());
            LetterThree.setOnDragListener(new MyDragListener());
            LetterFour.setOnDragListener(new MyDragListener());
            LetterFive.setOnDragListener(new MyDragListener());
            LetterSix.setVisibility(View.GONE);
            LetterSeven.setVisibility(View.GONE);
            LetterEight.setVisibility(View.GONE);

        } else if (letterCount == 6) {

            LetterOne.setOnDragListener(new MyDragListener());
            LetterTwo.setOnDragListener(new MyDragListener());
            LetterThree.setOnDragListener(new MyDragListener());
            LetterFour.setOnDragListener(new MyDragListener());
            LetterFive.setOnDragListener(new MyDragListener());
            LetterSix.setOnDragListener(new MyDragListener());
            LetterSeven.setVisibility(View.GONE);
            LetterEight.setVisibility(View.GONE);

        } else if (letterCount == 7) {

            LetterOne.setOnDragListener(new MyDragListener());
            LetterTwo.setOnDragListener(new MyDragListener());
            LetterThree.setOnDragListener(new MyDragListener());
            LetterFour.setOnDragListener(new MyDragListener());
            LetterFive.setOnDragListener(new MyDragListener());
            LetterSix.setOnDragListener(new MyDragListener());
            LetterSeven.setOnDragListener(new MyDragListener());
            LetterEight.setVisibility(View.GONE);

        } else if (letterCount == 8) {

            LetterOne.setOnDragListener(new MyDragListener());
            LetterTwo.setOnDragListener(new MyDragListener());
            LetterThree.setOnDragListener(new MyDragListener());
            LetterFour.setOnDragListener(new MyDragListener());
            LetterFive.setOnDragListener(new MyDragListener());
            LetterSix.setOnDragListener(new MyDragListener());
            LetterSeven.setOnDragListener(new MyDragListener());
            LetterEight.setOnDragListener(new MyDragListener());
        }


    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }
    }
}