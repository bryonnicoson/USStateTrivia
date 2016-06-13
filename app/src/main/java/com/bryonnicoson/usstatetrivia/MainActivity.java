package com.bryonnicoson.usstatetrivia;



import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private State[] mState = new State[50];
    private ArrayList<Integer> mQuizDeck = new ArrayList<Integer>();
    private ArrayList<Integer> mButtonOrder = new ArrayList<Integer>();
    private ArrayList<Integer> wrongs = new ArrayList<Integer>();
    private ImageView mImgState;
    private Button mButtons[] = new Button[4];
    private TextView mScore;
    private int score;
    private int attempts;
    private int cardCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgState = (ImageView) findViewById(R.id.img_state);

        mButtons[0] = (Button) findViewById(R.id.btn_a);
        mButtons[1] = (Button) findViewById(R.id.btn_b);
        mButtons[2] = (Button) findViewById(R.id.btn_c);
        mButtons[3] = (Button) findViewById(R.id.btn_d);

        mScore = (TextView) findViewById(R.id.txt_score);

        // Create the 50 United States States of America - database next
        // abbr, name, date, capital, bird, tree, flower

        mState[0] = new State("AL", "Alabama", "1819-12-19", "Montgomery", "YellowHammer", "Southern Pine", "Camelia");
        mState[1] = new State("AK", "Alaska", "1959-1-3", "Juneau", "Willow Ptarmigan", "Sitka Spruce", "Forget-me-not");
        mState[2] = new State("AZ", "Arizona", "1912-2-14", "Phoenix", "Cactus Wren", "Paloverde", "Saguaro cactus");
        mState[3] = new State("AR", "Arkansas", "1836-6-15", "Little Rock", "Mockingbird", "Pine", "Apple blossom");
        mState[4] = new State("CA", "California", "1850-9-9", "Sacramento", "Valley Quail", "Redwood", "Golden poppy");
        mState[5] = new State("CO", "Colorado", "1876-8-1", "Denver", "Lark Bunting", "Blue Spruce", "Rocky Mountain Columbine");
        mState[6] = new State("CT", "Connecticut", "1788-1-9", "Hartford", "Robin", "White Oak", "Mountain laurel");
        mState[7] = new State("DE", "Delaware", "1787-12-07", "Dover", "Blue Hen Chicken", "American Holly", "Peach blossom");
        mState[8] = new State("FL", "Florida", "1845-3-3", "Tallahassee", "Mockingbird", "Cabbage Palmetto", "Orange blossom");
        mState[9] = new State("GA", "Georgia", "1788-1-2", "Atlanta", "Brown Thrasher", "Live Oak", "Cherokee rose");
        mState[10] = new State("HI", "Hawaii", "1959-8-21", "Honolulu", "Nene", "Kukui", "Hibiscus");
        mState[11] = new State("ID", "Idaho", "1890-7-3", "Boise", "Mountain Bluebird", "Western White Pine", "Syringa");
        mState[12] = new State("IL", "Illinois", "1818-12-3", "Springfield", "Cardinal", "White Oak", "Native Violet");
        mState[13] = new State("IN", "Indiana", "1816-12-11", "Indianapolis", "Cardinal", "Yellow Poplar", "Peony");
        mState[14] = new State("IA", "Iowa", "1846-12-28", "Des Moines", "Eastern Goldfinch", "Oak", "Wild Rose");
        mState[15] = new State("KS", "Kansas", "1861-1-29", "Topeka", "Western Meadowlark", "Cottonwood", "Native sunflower");
        mState[16] = new State("KY", "Kentucky", "1792-6-1", "Frankfort", "Cardinal", "Yellow Poplar", "Goldenrod");
        mState[17] = new State("LA", "Louisiana", "1812-4-30", "Baton Rouge", "Eastern Brown Pelican", "Bald cypress", "Magnolia");
        mState[18] = new State("ME", "Maine", "1820-3-15", "Augusta", "Chickadee", "Eastern White Pine", "Pine cone & tassel");
        mState[19] = new State("MD", "Maryland", "1788-4-28", "Annapolis", "Oriole", "White Oak", "Black Eyed Susan");
        mState[20] = new State("MA", "Massachusetts", "1788-2-6", "Boston", "Chickadee", "American Elm", "Mayflower");
        mState[21] = new State("MI", "Michigan", "1837-1-26", "Lansing", "Robin", "Eastern White Pine", "Apple blossom");
        mState[22] = new State("MN", "Minnesota", "1858-5-11", "St. Paul", "Common Loon", "Red Pine", "Lady slipper");
        mState[23] = new State("MS", "Mississippi", "1817-12-10", "Jackson", "Mockingbird", "Southern Magnolia", "Magnolia");
        mState[24] = new State("MO", "Missouri", "1821-8-10", "Jefferson City", "Bluebird", "Flowering Dogwood", "Hawthorn");
        mState[25] = new State("MT", "Montana", "1889-11-8", "Helena", "Western Meadowlark", "Ponderosa Pine", "Bitterroot");
        mState[26] = new State("NE", "Nebraska", "1867-3-1", "Lincoln", "Western Meadowlark", "Cottonwood", "Goldenrod");
        mState[27] = new State("NV", "Nevada", "1864-10-31", "Caron City", "Mountain Bluebird", "Bristlecone Pine", "Sagebrush");
        mState[28] = new State("NH", "New Hampshire", "1788-6-21", "Concord", "Purple Finch", "Paper Birch", "Purple lilac");
        mState[29] = new State("NJ", "New Jersey", "1787-12-18", "Trenton", "Eastern Goldfinch", "Northern Red Oak", "Purple violet");
        mState[30] = new State("NM", "New Mexico", "1912-1-26", "Santa Fe", "Roadrunner", "Pinyon", "Yucca");
        mState[31] = new State("NY", "New York", "1788-7-26", "Albany", "Bluebird", "Sugar Maple", "Rose");
        mState[32] = new State("NC", "North Carolina", "1789-11-21", "Raleigh", "Cardinal", "Pine", "Dogwood");
        mState[33] = new State("ND", "North Dakota", "1889-11-2", "Bismark", "Western Meadowlark", "American Elm", "Wild prairie rose");
        mState[34] = new State("OH", "Ohio", "1803-3-1", "Columbus", "Cardinal", "Buckeye", "Scarlet carnation");
        mState[35] = new State("OK", "Oklahoma", "1907-11-16", "Oklahoma City", "Scissor-tailed Flycatcher", "Eastern Redbud", "Mistletoe");
        mState[36] = new State("OR", "Oregon", "1859-2-14", "Salem", "Western Meadowlark", "Douglas fir", "Grape");
        mState[37] = new State("PA", "Pennsylvania", "1787-12-12", "Harrisburg", "Ruffed Grouse", "Eastern Hemlock", "Mountain laurel");
        mState[38] = new State("RI", "Rhode Island", "1790-5-29", "Providence", "Rhode Island Red", "Red Maple", "Violet");
        mState[39] = new State("SC", "South Carolina", "1788-5-23", "Columbia", "Great Carolina Wren", "Cabbage Palmetto", "Yellow jessamine");
        mState[40] = new State("SD", "South Dakota", "1889-11-2", "Pierre", "Ring-necked Pheasant", "White Spruce", "Pasque flower");
        mState[41] = new State("TN", "Tennessee", "1796-6-6", "Nashville", "Mockingbird", "Yellow poplar", "Purple iris");
        mState[42] = new State("TX", "Texas", "1845-12-29", "Austin", "Mockingbird", "Pecan", "Blue Bonnet");
        mState[43] = new State("UT", "Utah", "1896-1-4", "Salt Lake City", "American Seagull", "Blue Spruce", "Sego lilly");
        mState[44] = new State("VT", "Vermont", "1791-3-4", "Montpelier", "Hermit Thrush", "Sugar Maple", "Red clover");
        mState[45] = new State("VA", "Virginia", "1788-6-25", "Richmond", "Cardinal", "Flowering Dogwood", "Dogwood");
        mState[46] = new State("WA", "Washington", "1889-11-11", "Olympia", "Willow Goldfinch", "Western Hemlock", "Western rhododendron");
        mState[47] = new State("WV", "West Virginia", "1863-6-20", "Charleston", "Cardinal", "Sugar Maple", "Rhododendron");
        mState[48] = new State("WI", "Wisconsin", "1848-5-29", "Madison", "Robin", "Sugar Maple", "Wood violet");
        mState[49] = new State("WY", "Wyoming", "1890-7-10", "Cheyenne", "Western Meadowlark", "Cottonwood", "Indian paint brush");

        // shuffle a deck and launch the quiz routine using that deck
        mQuizDeck = shuffleDeck(50);
        gameMaster();

    }

    private void gameMaster() {
        if (cardCount == mQuizDeck.size()) {
            mScore.setText("Game Over!\nFinal Score: " + score + " / " + attempts + "\nTry again?");
            mButtons[1].setVisibility(View.GONE);
            mButtons[3].setVisibility(View.GONE);
            mButtons[0].setText("Yes");
            mButtons[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mQuizDeck = shuffleDeck(50);
                    score = 0;
                    attempts = 0;
                    cardCount = 0;
                    mScore.setText(score + " / " + attempts);
                    mButtons[1].setVisibility(View.VISIBLE);
                    mButtons[3].setVisibility(View.VISIBLE);
                    gameMaster();
                }
            });
            mButtons[2].setText("No");
            mButtons[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            });
        } else {
            quiz(mQuizDeck);
        }
    }

    // make a deck the size of lngth and shuffle it

    private ArrayList<Integer> shuffleDeck(int lngth) {

        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < lngth; i++) {
            ret.add(i);
        }
        long seed = System.nanoTime();
        Collections.shuffle(ret, new Random(seed));

        return(ret);
    }

    private void quiz(ArrayList<Integer> deck) {

        int card = deck.get(cardCount);

        Random rng = new Random(Double.doubleToLongBits(Math.random()));
        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < 3) {
            Integer next = rng.nextInt(deck.size());
            if (next != card) {
                generated.add(next);
            }
        }
        wrongs.addAll(0, generated);  // convert our set of unique distractors to an indexed list

        upDateQuestion(mState[card], wrongs);

//            int j = 0;
//            do {
//                boolean duplicate = false;
//                Random random = new Random(Double.doubleToLongBits(Math.random()));
//                int rInt = random.nextInt(deck.size());
//                for (int i = 0; i < wrongs.size(); i++) {
//                    if (rInt == wrongs.get(i)){
//                        duplicate = true;
//                    }
//                }
//                if (rInt == card) {
//                    duplicate = true;
//                }
//                if (duplicate == false) {
//                    wrongs.add(deck.get(rInt));
//                    j++;
//                }
//            } while( j < 3 );
    }

    private void upDateQuestion(State state, ArrayList<Integer> distractors) {

        // display the state png by assembling the resource location using state var
        // i need to fix this, but I learned a sh*t ton researching it, and it works

        String uri = "@drawable/" + state.getAbbr().toLowerCase();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);  // deprecated usage, but it works
        // Drawable res = ResourcesCompat.getDrawable(getResources(), imageResource, null);
        mImgState.setImageDrawable(res);

        // create and shuffle 1-4 to assign buttons correct/incorrect responses

        mButtonOrder = shuffleDeck(4);

        // THIS FOR LOOP MARKS THE SPOT WHERE I BEGAN TO UNDERSTAND THAT EVERYTHING IS AN OBJECT
        for (int i = 0; i < mButtonOrder.size(); i++) {
            if (i == 0) {
                mButtons[mButtonOrder.get(i)].setBackgroundResource(R.drawable.btn_correct);
                mButtons[mButtonOrder.get(i)].setText(state.getName());
                mButtons[mButtonOrder.get(i)].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        submitAnswer(true);
                    }
                });
            } else {
                mButtons[mButtonOrder.get(i)].setText(mState[distractors.get(i-1)].getName());
                mButtons[mButtonOrder.get(i)].setBackgroundResource(R.drawable.btn_incorrect);
                mButtons[mButtonOrder.get(i)].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        submitAnswer(false);
                    }
                });
            }
        }
    }
    private void submitAnswer(boolean correct) {
        attempts++;
        if (correct == true) {
            score++;
        }
        mScore.setText(Integer.toString(score) + " / " + Integer.toString(attempts));
        cardCount++;
        gameMaster();
    }

}
