package com.example.fabian.testratingbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btSubmit;
    private RatingBar ratingBar;
    private RatingBar iRatingBar;
    private RatingBar customRatingBar;
    private TextView tvRating;
    private TextView tvQuant;
    private int contador = 0;
    private float valTotal = 0;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btSubmit = (Button) view.findViewById( R.id.submint_button );
        ratingBar = (RatingBar) view.findViewById( R.id.ratingBar );
        iRatingBar = (RatingBar) view.findViewById( R.id.ratingBarIndicator );
        customRatingBar = (RatingBar) view.findViewById( R.id.rb_custom );
        tvRating = (TextView) view.findViewById( R.id.tv_rating );
        tvQuant = (TextView) view.findViewById( R.id.tv_quant );

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText( getContext(), String.valueOf( rating ), Toast.LENGTH_LONG).show();

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valTotal += ratingBar.getRating();
                contador++;
                float res = valTotal / contador;
                iRatingBar.setRating( res );
                customRatingBar.setRating( res );
                tvRating.setText( String.format("%.2f", res ) );
                tvQuant.setText( String.valueOf( contador ) );

            }
        });

        return view;
    }
}
